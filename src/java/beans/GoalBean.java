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
import javax.servlet.ServletException;
import misc.DbConnect;

/**
 *
 * @author Cypher
 */
public class GoalBean implements Serializable
{
    private int submitter;
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
    
    public void persist() throws ServletException
    {
        try
        {
            DbConnect databaseConnection = new DbConnect();
            Connection con = databaseConnection.getCon();
       
            PreparedStatement ps = con.prepareStatement("INSERT INTO goal "
                                   + "(startDate, endDate, progress, category, "
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
        catch(Exception e)
        {
            throw new ServletException("Goal persist issue: "+e);
        }
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
}
