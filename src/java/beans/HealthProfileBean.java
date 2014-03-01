/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.io.Serializable;

/**
 *
 * @author Cypher
 */
public class HealthProfileBean implements Serializable
{
    private double userHeight, userWeight, userBMI, userBodyFatPercent;
    private int restingHeartRate, peakHeartRate;
    
    public HealthProfileBean(){}

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
}
