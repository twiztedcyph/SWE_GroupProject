/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import misc.DbConnect;

/**
 *
 * @author Cypher
 */
public class ExerciseBean implements Serializable
{
    private String exerciseType, intensity;
    private Date exerciseDate;
    private Time exerciseTime;
    private double exerciseDuration;
    private int  member_id;

    public ExerciseBean(String exerciseType, String intensity, 
            Date exerciseDate, Time exerciseTime, double exerciseDuration,
            int member_id) {
        this.exerciseType = exerciseType;
        this.intensity = intensity;
        this.exerciseDate = exerciseDate;
        this.exerciseTime = exerciseTime;
        this.exerciseDuration = exerciseDuration;
        this.member_id = member_id;
    }
    
    public ExerciseBean(ResultSet rs) throws SQLException
    {
        this.member_id = rs.getInt("submitter");
        this.exerciseDate = rs.getDate("date");
        this.intensity = rs.getString("intensity");
        this.exerciseType = rs.getString("exercise_type");
        this.exerciseDuration = rs.getInt("duration");
        this.exerciseTime = rs.getTime("time");
        
        
    }
    public ExerciseBean(){}

    public void persist() throws SQLException
    {
       
            DbConnect databaseConnection = new DbConnect();
            Connection con = databaseConnection.getCon();
       
            PreparedStatement ps = con.prepareStatement("INSERT INTO exercise "
                                   + "(exercise_type, intensity, date, time, "
                                    + "duration, submitter)"
                                    + "VALUES(?,?,?,?,?,?)"); 
            
            ps.setString(1, exerciseType);
            ps.setString(2, intensity);
            ps.setDate(3, exerciseDate);
            ps.setTime(4, exerciseTime);
            ps.setDouble(5, exerciseDuration);
            ps.setInt(6, member_id);
            
            ps.executeUpdate();
            
            con.close();
    }
    public String getExerciseType()
    {
        return exerciseType;
    }

    public void setExerciseType(String exerciseType)
    {
        this.exerciseType = exerciseType;
    }

    public String getIntensity()
    {
        return intensity;
    }

    public void setIntensity(String intensity)
    {
        this.intensity = intensity;
    }

    public Date getExerciseDate()
    {
        return exerciseDate;
    }

    public void setExerciseDate(Date exerciseDate)
    {
        this.exerciseDate = exerciseDate;
    }

    public Time getExerciseTime()
    {
        return exerciseTime;
    }

    public void setExerciseTime(Time exerciseTime)
    {
        this.exerciseTime = exerciseTime;
    }

    public double getExerciseDuration()
    {
        return exerciseDuration;
    }

    

    public int getId() {
        return member_id;
    }

    public void setExerciseDuration(double exerciseDuration)
    {
        this.exerciseDuration = exerciseDuration;
    }
    
    public static void deleteExercise(int exerciseID , int userID) throws SQLException
    {
        misc.DbConnect connection = new misc.DbConnect();
        Connection con = connection.getCon();
        
        PreparedStatement ps = con.prepareStatement("DELETE from exercise WHERE id=? AND submitter =?;");
        
        ps.setInt(1, exerciseID);
        ps.setInt(2, userID);
        
        ps.executeUpdate();
        
        con.close();
    }
    
    public ArrayList<ExerciseBean> getExercise(int memberId) throws SQLException
    {
        ArrayList<ExerciseBean> exerciseList = new ArrayList<>();
        misc.DbConnect dbConnect = new misc.DbConnect();

        Connection myCon = dbConnect.getCon();

        PreparedStatement ps = myCon.prepareStatement("Select * from exercise where submitter = ?");
        ps.setInt(1, memberId);
        System.out.println("Member ID = "+memberId);
        ResultSet rs = ps.executeQuery();
        
        while(rs.next())
        {
            exerciseList.add(new ExerciseBean(rs));
        }
        
        myCon.close();
        return exerciseList;
    }
}
