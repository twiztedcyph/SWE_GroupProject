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
import java.util.ArrayList;

/**
 *
 * @author Cypher
 */
public class MemberBean implements Serializable
{
    private HealthyNormBean healthyNorm;
    private LifeStyleBean lifeStyle;
    private ArrayList<GoalBean> goals;
    //Not sure about the current group system....
    private BasicInformationBean basicInfomation;
    //Again not sure about messages....
    private HealthProfileBean healthProfile;
    
    public MemberBean(){}

    public HealthyNormBean getHealthyNorm()
    {
        return healthyNorm;
    }

    public void setHealthyNorm(HealthyNormBean healthyNorm)
    {
        this.healthyNorm = healthyNorm;
    }

    public LifeStyleBean getLifeStyle()
    {
        return lifeStyle;
    }

    public void setLifeStyle(LifeStyleBean lifeStyle)
    {
        this.lifeStyle = lifeStyle;
    }

    public ArrayList<GoalBean> getGoals()
    {
        return goals;
    }

    public void setGoals(ArrayList<GoalBean> goals)
    {
        this.goals = goals;
    }

    public BasicInformationBean getBasicInfomation()
    {
        return basicInfomation;
    }

    public void setBasicInfomation(BasicInformationBean basicInfomation)
    {
        this.basicInfomation = basicInfomation;
    }

    public HealthProfileBean getHealthProfile()
    {
        return healthProfile;
    }

    public void setHealthProfile(HealthProfileBean healthProfile)
    {
        this.healthProfile = healthProfile;
    }
    
}
