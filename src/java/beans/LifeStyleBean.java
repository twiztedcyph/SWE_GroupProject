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
public class LifeStyleBean implements Serializable
{
    private String userOccupation;
    private String[] userHobbies;
    
    public LifeStyleBean(){}

    public String getUserOccupation()
    {
        return userOccupation;
    }

    public void setUserOccupation(String userOccupation)
    {
        this.userOccupation = userOccupation;
    }

    public String[] getUserHobbies()
    {
        return userHobbies;
    }

    public void setUserHobbies(String[] userHobbies)
    {
        this.userHobbies = userHobbies;
    }
}
