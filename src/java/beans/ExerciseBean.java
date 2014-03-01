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
public class ExerciseBean implements Serializable
{
    private String exerciseType, intensity;
    private Date exerciseDate;
    private Time exerciseTime;
    private double exerciseDuration;
    
    public ExerciseBean(){}

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

    public void setExerciseDuration(double exerciseDuration)
    {
        this.exerciseDuration = exerciseDuration;
    }
}
