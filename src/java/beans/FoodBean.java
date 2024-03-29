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

/**
 *
 * @author Cypher
 */
public class FoodBean implements Serializable
{
    private int memberId;
    private String foodName;
    private Date dateEaten;
    private Time timeEaten;
    private double proteinPerHundredGrams, carbsPerHundredGrams, 
            nonSatFatPerHundredGrams, satFatPerHundredGrams, 
            kiloCalPerHundredGrams, sugarPerHundredGrams, 
            saltPerHundredGrams;
    
    public FoodBean(){}

    public FoodBean(int memberId, String foodName, Date dateEaten, 
            Time timeEaten, double proteinPerHundredGrams, 
            double carbsPerHundredGrams, double NonSatFatPerHundredGrams, 
            double satFatPerHundredGrams, double kiloCalPerHundredGrams, 
            double sugarPerHundredGrams, double saltPerHundredGrams)
    {
        this.memberId = memberId;
        this.foodName = foodName;
        this.dateEaten = dateEaten;
        this.timeEaten = timeEaten;
        this.proteinPerHundredGrams = proteinPerHundredGrams;
        this.carbsPerHundredGrams = carbsPerHundredGrams;
        this.nonSatFatPerHundredGrams = NonSatFatPerHundredGrams;
        this.satFatPerHundredGrams = satFatPerHundredGrams;
        this.kiloCalPerHundredGrams = kiloCalPerHundredGrams;
        this.sugarPerHundredGrams = sugarPerHundredGrams;
        this.saltPerHundredGrams = saltPerHundredGrams;
    }
    
    private FoodBean(ResultSet rs) throws SQLException
    {
        this.memberId = rs.getInt("member_id");
        this.foodName = rs.getString("foodname");
        this.dateEaten = rs.getDate("dateeaten");
        this.timeEaten = rs.getTime("timeeaten");
        this.proteinPerHundredGrams = rs.getDouble("protein");
        this.carbsPerHundredGrams = rs.getDouble("carbohydrate");
        this.nonSatFatPerHundredGrams = rs.getDouble("unsatfat");
        this.satFatPerHundredGrams = rs.getDouble("satfat");
        this.kiloCalPerHundredGrams = rs.getDouble("sugar");
        this.sugarPerHundredGrams = rs.getDouble("salt");
        this.saltPerHundredGrams = rs.getDouble("kcalories");
    }
    
    //<editor-fold defaultstate="collapsed" desc="Get / set methods">
    public String getFoodName()
    {
        return foodName;
    }
    
    public void setFoodName(String foodName)
    {
        this.foodName = foodName;
    }
    
    public Date getDateEaten()
    {
        return dateEaten;
    }
    
    public void setDateEaten(Date dateEaten)
    {
        this.dateEaten = dateEaten;
    }
    
    public Time getTimeEaten()
    {
        return timeEaten;
    }
    
    public void setTimeEaten(Time timeEaten)
    {
        this.timeEaten = timeEaten;
    }
    
    public double getProteinPerHundredGrams()
    {
        return proteinPerHundredGrams;
    }
    
    public void setProteinPerHundredGrams(double proteinPerHundredGrams)
    {
        this.proteinPerHundredGrams = proteinPerHundredGrams;
    }
    
    public double getCarbsPerHundredGrams()
    {
        return carbsPerHundredGrams;
    }
    
    public void setCarbsPerHundredGrams(double carbsPerHundredGrams)
    {
        this.carbsPerHundredGrams = carbsPerHundredGrams;
    }
    
    public double getNonSatFatPerHundredGrams()
    {
        return nonSatFatPerHundredGrams;
    }
    
    public void setNonSatFatPerHundredGrams(double NonSatFatPerHundredGrams)
    {
        this.nonSatFatPerHundredGrams = NonSatFatPerHundredGrams;
    }
    
    public double getSatFatPerHundredGrams()
    {
        return satFatPerHundredGrams;
    }
    
    public void setSatFatPerHundredGrams(double satFatPerHundredGrams)
    {
        this.satFatPerHundredGrams = satFatPerHundredGrams;
    }
    
    public double getKiloCalPerHundredGrams()
    {
        return kiloCalPerHundredGrams;
    }
    
    public void setKiloCalPerHundredGrams(double kiloCalPerHundredGrams)
    {
        this.kiloCalPerHundredGrams = kiloCalPerHundredGrams;
    }
    
    public double getSugarPerHundredGrams()
    {
        return sugarPerHundredGrams;
    }
    
    public void setSugarPerHundredGrams(double sugarPerHundredGrams)
    {
        this.sugarPerHundredGrams = sugarPerHundredGrams;
    }
    
    public double getSaltPerHundredGrams()
    {
        return saltPerHundredGrams;
    }
    
    public void setSaltPerHundredGrams(double saltPerHundredGrams)
    {
        this.saltPerHundredGrams = saltPerHundredGrams;
    }

    public int getMemberId()
    {
        return memberId;
    }

    public void setMemberId(int memberId)
    {
        this.memberId = memberId;
    }
//</editor-fold>
    
    @Override
    public String toString()
    {
        return "Food name = " + foodName 
                + "\\nDate eaten = " + dateEaten 
                + "\\nTime eaten = " + timeEaten 
                + "\\nProtein = " + proteinPerHundredGrams 
                + "\\nCarbohydrates = " + carbsPerHundredGrams 
                + "\\nNon saturating fat = " + nonSatFatPerHundredGrams 
                + "\\nSaturating fat = " + satFatPerHundredGrams 
                + "\\nKilo Calories = " + kiloCalPerHundredGrams 
                + "\\nSugar = " + sugarPerHundredGrams 
                + "\\nSalt = " + saltPerHundredGrams;
    }
    
    public void persist() throws SQLException
    {
        misc.DbConnect dbConnect = new misc.DbConnect();

        try (Connection myCon = dbConnect.getCon())
        {
            PreparedStatement ps = myCon.prepareStatement("INSERT INTO food "
                    + "(foodname, dateeaten, timeeaten, protein, carbohydrate, "
                    + "unsatfat, satfat, sugar, salt, kcalories, member_id) "
                    + "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, foodName);
            ps.setDate(2, dateEaten);
            ps.setTime(3, timeEaten);
            ps.setDouble(4, proteinPerHundredGrams);
            ps.setDouble(5, carbsPerHundredGrams);
            ps.setDouble(6, nonSatFatPerHundredGrams);
            ps.setDouble(7, satFatPerHundredGrams);
            ps.setDouble(8, sugarPerHundredGrams);
            ps.setDouble(9, saltPerHundredGrams);
            ps.setDouble(10, nonSatFatPerHundredGrams);
            ps.setInt(11, memberId);
            ps.executeUpdate();
        }
    }
    
    public ArrayList<FoodBean> getFood(int memberId) throws SQLException
    {
        ArrayList<FoodBean> foodList = new ArrayList<>();
        misc.DbConnect dbConnect = new misc.DbConnect();

        try (Connection myCon = dbConnect.getCon())
        {
            PreparedStatement ps = myCon.prepareStatement("Select * from food where member_id = ?");
            ps.setInt(1, memberId);
            
            ResultSet rs = ps.executeQuery();
            int i = 0;
            
            while(rs.next())
            {
                foodList.add(new FoodBean(rs));
            }
        }
        return foodList;
    }
}
