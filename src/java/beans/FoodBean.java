/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Cypher
 */
public class FoodBean implements Serializable
{
    private String foodName;
    private Date dateEaten;
    private Time timeEaten;
    private double proteinPerHundredGrams, carbsPerHundredGrams, 
            NonSatFatPerHundredGrams, satFatPerHundredGrams, 
            kiloCalPerHundredGrams, sugarPerHundredGrams, 
            saltPerHundredGrams, fibrePerHundredGrams;
    
    public FoodBean(){}

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
        return NonSatFatPerHundredGrams;
    }

    public void setNonSatFatPerHundredGrams(double NonSatFatPerHundredGrams)
    {
        this.NonSatFatPerHundredGrams = NonSatFatPerHundredGrams;
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

    public double getFibrePerHundredGrams()
    {
        return fibrePerHundredGrams;
    }

    public void setFibrePerHundredGrams(double fibrePerHundredGrams)
    {
        this.fibrePerHundredGrams = fibrePerHundredGrams;
    }
}
