/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Cypher
 */
public class GoalBean implements Serializable
{
    private Date goalStartDate, goalEndDate;
    private double goalProgress;
    
    public GoalBean(){}

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
