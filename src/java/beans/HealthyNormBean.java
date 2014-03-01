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
public class HealthyNormBean implements Serializable
{
    private double normalWeight, normalBMI, normalRestingHeartRate,
            normalPeakHeartRate, normalBodyFatPercent;
    
    public HealthyNormBean(){}

    public double getNormalWeight()
    {
        return normalWeight;
    }

    public void setNormalWeight(double normalWeight)
    {
        this.normalWeight = normalWeight;
    }

    public double getNormalBMI()
    {
        return normalBMI;
    }

    public void setNormalBMI(double normalBMI)
    {
        this.normalBMI = normalBMI;
    }

    public double getNormalRestingHeartRate()
    {
        return normalRestingHeartRate;
    }

    public void setNormalRestingHeartRate(double normalRestingHeartRate)
    {
        this.normalRestingHeartRate = normalRestingHeartRate;
    }

    public double getNormalPeakHeartRate()
    {
        return normalPeakHeartRate;
    }

    public void setNormalPeakHeartRate(double normalPeakHeartRate)
    {
        this.normalPeakHeartRate = normalPeakHeartRate;
    }

    public double getNormalBodyFatPercent()
    {
        return normalBodyFatPercent;
    }

    public void setNormalBodyFatPercent(double normalBodyFatPercent)
    {
        this.normalBodyFatPercent = normalBodyFatPercent;
    }
}
