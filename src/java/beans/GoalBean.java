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
import javax.servlet.ServletException;
import misc.DbConnect;

/**
 *
 * @author Cypher
 */
public class GoalBean implements Serializable
{
    private int submitter, id;
    boolean groupGoal;
    private Date goalStartDate, goalEndDate;
    private double goalProgress, aim;
    private String category, type;
    
    public GoalBean(){}
    
    public GoalBean(int givenSubmitter, boolean givenGroupGoal,  
                    Date givenStartDate, Date givenEndDate, double givenAim, 
                    String givenCategory, String givenType)
    {
        submitter = givenSubmitter;
        groupGoal = givenGroupGoal;
        goalStartDate = givenStartDate;
        goalEndDate = givenEndDate;
        aim = givenAim;
        category = givenCategory;
        type = givenType;
        goalProgress = 0;
    }

    public GoalBean(ResultSet rs) throws SQLException
    {

            this.id = rs.getInt("id");
            this.submitter = rs.getInt("submitter");
            this.groupGoal = rs.getBoolean("isgroup");
            this.goalStartDate = rs.getDate("start_date");
            this.goalEndDate = rs.getDate("end_date");
            this.aim = rs.getDouble("aim");
            this.category = rs.getString("category");
            this.type = rs.getString("type");
            this.goalProgress = rs.getDouble("progress");
    }
    
    public static GoalBean findByID(int goalID) throws SQLException
    {
        DbConnect databaseConnection = new DbConnect();
            Connection con = databaseConnection.getCon();

        PreparedStatement ps = con.prepareStatement("Select * from goal where id = ?");
        ps.setInt(1, goalID);

        return new GoalBean(ps.executeQuery());
        
    }
    
    public String toString()
    {
        String goalString = String.format("Submitted by: %s\n"
                                          + "Group Goal?: %s\n"
                                          + "Start Date: %s\n"
                                          + "End Date: %s\n"
                                          + "Aim: %s\n"
                                          + "Category: %s\n"
                                          + "Type: %s\n"
                                          + "Progress: %s\n", 
                
                                          submitter, groupGoal, goalStartDate,
                                          goalEndDate, aim, category, type,
                                          goalProgress);
         
        return goalString;
            
    }
    
    public void persist() throws SQLException
    {
       
            DbConnect databaseConnection = new DbConnect();
            Connection con = databaseConnection.getCon();
       
            PreparedStatement ps = con.prepareStatement("INSERT INTO goal "
                                   + "(start_date, end_date, progress, category, "
                                    + "type, aim, isgroup, submitter)"
                                    + "VALUES(?,?,?,?,?,?,?,?)"); 
            
            ps.setDate(1, goalStartDate);
            ps.setDate(2, goalEndDate);
            ps.setDouble(3, goalProgress);
            ps.setString(4, category);
            ps.setString(5, type);
            ps.setDouble(6, aim);
            ps.setBoolean(7, groupGoal);
            ps.setInt(8, submitter);
            
            ps.executeUpdate();
            
            con.close();
    }
    
    public int getSubmitter()
    {
        return submitter;
    }

    public void setSubmitter(int submitter)
    {
        this.submitter = submitter;
    }

    public boolean isGroupGoal()
    {
        return groupGoal;
    }

    public void setGroupGoal(boolean groupGoal)
    {
        this.groupGoal = groupGoal;
    }

    public double getAim()
    {
        return aim;
    }

    public void setAim(double aim)
    {
        this.aim = aim;
    }

    public String getCategory()
    {
        return category;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }
    
    public Date getGoalStartDate()
    {
        return goalStartDate;
    }

    public void setGoalStartDate(Date goalStartDate)
    {
        this.goalStartDate = goalStartDate;
    }

    public Date getGoalEndDate()
    {
        return goalEndDate;
    }

    public void setGoalEndDate(Date goalEndDate)
    {
        this.goalEndDate = goalEndDate;
    }

    public double getGoalProgress()
    {
        return goalProgress;
    }

    public void setGoalProgress(double goalProgress)
    {
        this.goalProgress = goalProgress;
    }
    
    public int getID()
    {
        return id;
    }
    
    public static void deleteGoal(int goalID, int userID) throws SQLException
    {
        misc.DbConnect connection = new misc.DbConnect();
        Connection con = connection.getCon();
        
        PreparedStatement ps = con.prepareStatement("DELETE from GOAL WHERE id=? AND submitter =?;");
        
        ps.setInt(1, goalID);
        ps.setInt(2, userID);
        
        ps.executeUpdate();
        
        con.close();
    }
}
