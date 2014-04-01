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

/**
 *
 * @author Cypher
 */
public class LifeStyleBean implements Serializable
{
    private String userOccupation;
    private String[] userHobbies;
    private int memberId;
    
    public LifeStyleBean(){}
    
    public LifeStyleBean(ResultSet resultSet) throws SQLException
    {
        while(resultSet.next())
        {
            this.memberId = resultSet.getInt("id");
            this.userHobbies = resultSet.getString("hobbies").split("\\#");
            this.userOccupation = resultSet.getString("occupation");
        }
    }

    public LifeStyleBean(String userOccupation, String[] userHobbies, int memberId)
    {
        this.userOccupation = userOccupation;
        this.userHobbies = userHobbies;
        this.memberId = memberId;
    }

    
    
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

    public int getMemberId()
    {
        return memberId;
    }

    public void setMemberId(int memberId)
    {
        this.memberId = memberId;
    }
    
    public LifeStyleBean getLifeStyle(int memberId) throws SQLException
    {
         misc.DbConnect dbConnect = new misc.DbConnect();
         String sql = "select * from lifestyle where member_id = " + memberId + ";";
         ResultSet rs = dbConnect.runQuery(sql);
         return new LifeStyleBean(rs);
    }
    
    public void persist()throws SQLException
    {
        misc.DbConnect dbConnect = new misc.DbConnect();

        Connection myCon = dbConnect.getCon();

        PreparedStatement ps = myCon.prepareStatement("INSERT INTO lifestyle (occupation, hobbies, member_id) values(?, ? ,?)");
        
        ps.setString(1, userOccupation);
        
        StringBuilder sb = new StringBuilder();
        for (String userHobbie : userHobbies)
        {
            sb.append(userHobbie).append("#");
        }
        ps.setString(2, sb.toString());
        ps.setInt(3, memberId);
        ps.executeUpdate();
    }
}
