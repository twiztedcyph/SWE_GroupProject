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
public class GoalTargetBean implements Serializable
{
    private String targetCategory, targetType, targetAim;
    
    public GoalTargetBean(){}

    public String getTargetCategory()
    {
        return targetCategory;
    }

    public void setTargetCategory(String targetCategory)
    {
        this.targetCategory = targetCategory;
    }

    public String getTargetType()
    {
        return targetType;
    }

    public void setTargetType(String targetType)
    {
        this.targetType = targetType;
    }

    public String getTargetAim()
    {
        return targetAim;
    }

    public void setTargetAim(String targetAim)
    {
        this.targetAim = targetAim;
    }
}
