/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import misc.DbConnect;

/**
 *
 * @author Cypher
 */
public class HealthProfileBean implements Serializable
{
    private double userHeight, userWeight, userBMI, userBodyFatPercent, healthRating;
    private int restingHeartRate, peakHeartRate, member_id;

    public HealthProfileBean(double userHeight, double userWeight, double userBMI, 
            double userBodyFatPercent, int restingHeartRate, int peakHeartRate, int member_id) {
        this.userHeight = userHeight;
        this.userWeight = userWeight;
        this.userBMI = userBMI;
        this.userBodyFatPercent = userBodyFatPercent;
        this.restingHeartRate = restingHeartRate;
        this.peakHeartRate = peakHeartRate;
        this.member_id = member_id;
        this.healthRating = calculateHealthRating();
    }
    
    public HealthProfileBean(ResultSet rs) throws SQLException
    {
        this.member_id = rs.getInt("member_id");
        this.peakHeartRate = rs.getInt("peak_heartrate");
        this.restingHeartRate = rs.getInt("resting_heartrate");
        this.userHeight = rs.getDouble("user_height");
        this.userWeight = rs.getDouble("user_weight");
        this.userBMI = rs.getDouble("user_bmi");
        this.userBodyFatPercent = rs.getDouble("user_body_fat");
    }
    public HealthProfileBean(){}
    
    public void persist() throws SQLException
    {
    DbConnect databaseConnection = new DbConnect();
            Connection con = databaseConnection.getCon();
       
            PreparedStatement ps = con.prepareStatement("UPDATE  goal "
                                   + " set user_height = ?, user_weight = ? , user_bmi = ?, user_body_fat = ?,"
                                    + "peak_heartrate = ?, rest_heartrate = ?, health_rating = ? where member_id = ?");
                                    
            
            ps.setDouble(1, userHeight);
            ps.setDouble(2, userWeight);
            ps.setDouble(3, userBMI);
            ps.setDouble(4, userBodyFatPercent);
            ps.setInt(5, peakHeartRate);
            ps.setInt(6, restingHeartRate);
            ps.setDouble(7, calculateHealthRating());
            ps.setInt(8, member_id);
            
            ps.executeUpdate();
            
            con.close();
            
    }
    
    public static HealthProfileBean retrieveOne(int member_id) throws SQLException
    {
        misc.DbConnect dbConnect = new misc.DbConnect();
        System.out.println("hehehe"+member_id);
        PreparedStatement ps;
        try (Connection myCon = dbConnect.getCon()) {
            ps = myCon.prepareStatement("Select * from healthy_profile where member_id = ?");
            ps.setInt(1, member_id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return new HealthProfileBean(rs);
        }
    }

    public double getUserHeight()
    {
        return userHeight;
    }

    public void setUserHeight(double userHeight)
    {
        this.userHeight = userHeight;
    }

    public double getUserWeight()
    {
        return userWeight;
    }

    public void setUserWeight(double userWeight)
    {
        this.userWeight = userWeight;
    }

    public double getUserBMI()
    {
        return userBMI;
    }

    public void setUserBMI(double userBMI)
    {
        this.userBMI = userBMI;
    }

    public double getUserBodyFatPercent()
    {
        return userBodyFatPercent;
    }

    public void setUserBodyFatPercent(double userBodyFatPercent)
    {
        this.userBodyFatPercent = userBodyFatPercent;
    }

    public int getRestingHeartRate()
    {
        return restingHeartRate;
    }

    public void setRestingHeartRate(int restingHeartRate)
    {
        this.restingHeartRate = restingHeartRate;
    }

    public int getPeakHeartRate()
    {
        return peakHeartRate;
    }

    public void setPeakHeartRate(int peakHeartRate)
    {
        this.peakHeartRate = peakHeartRate;
    }

    public double getHealthRating() {
        return healthRating;
    }

    public void setHealthRating(double healthRating) {
        this.healthRating = healthRating;
    }

    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }
    
    public double calculateHealthRating()
    {
        return 1000;
    }
}
