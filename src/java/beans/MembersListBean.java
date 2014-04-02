/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.io.Serializable;
import java.sql.*;
import misc.DbConnect;

/**
 *
 * @author Cypher
 */
public class MembersListBean implements Serializable
{
    private int userID, groupID;
    
    public MembersListBean(int givenUserID, int givenGroupID)
    {
        this.userID = givenUserID;
        this.groupID = givenGroupID;
    }
    
    public MembersListBean(ResultSet rs) throws SQLException
    {
        this.userID = rs.getInt("member_id");
        this.groupID = rs.getInt("group_id");
    }
    
    public void persist() throws SQLException
    {
       
            DbConnect databaseConnection = new DbConnect();
            Connection con = databaseConnection.getCon();
       
            PreparedStatement ps = con.prepareStatement("INSERT INTO group_member_list"
                                   + "(group_id, member_id) "
                                    + "VALUES(?,?)"); 
            
            ps.setInt(1, groupID);
            ps.setInt(2, userID); 
            ps.executeUpdate();
            
            con.close();
    }
   
    public int getUserID()
    {
        return userID;
    }

    public int getGroupID()
    {
        return groupID;
    }
    
    
}
