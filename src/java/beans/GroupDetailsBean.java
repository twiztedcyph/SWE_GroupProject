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
public class GroupDetailsBean implements Serializable
{
    private String groupName;
    private String groupDescription;
    private int groupOwner;
    
    public GroupDetailsBean(){}

    public GroupDetailsBean(String groupName, 
            String groupDescription, int groupOwner)
    {
        this.groupName = groupName;
        this.groupDescription = groupDescription;
        this.groupOwner = groupOwner;
    }
    
    public GroupDetailsBean(ResultSet rs) throws SQLException
    {
        this.groupName = rs.getString("group_name");
        this.groupDescription = rs.getString("group_description");
        this.groupOwner = rs.getInt("group_owner");
    }

    //<editor-fold defaultstate="collapsed" desc="Get / set methods">
    public String getGroupName()
    {
        return groupName;
    }
    
    public void setGroupName(String groupName)
    {
        this.groupName = groupName;
    }
    
    public String getGroupDescription()
    {
        return groupDescription;
    }
    
    public void setGroupDescription(String groupDescription)
    {
        this.groupDescription = groupDescription;
    }
    
    public int getGroupOwner()
    {
        return groupOwner;
    }
    
    public void setGroupOwner(int groupOwner)
    {
        this.groupOwner = groupOwner;
    }
//</editor-fold>
    
    public ArrayList<GroupDetailsBean> getMemberGroups(int memberId) throws SQLException
    {
        ArrayList<GroupDetailsBean> result = new ArrayList<>();
        misc.DbConnect dbConnect = new misc.DbConnect();
        try (Connection myCon = dbConnect.getCon())
        {
            PreparedStatement ps = myCon.prepareStatement("select "
                    + "group_details.group_name, "
                    + "group_details.group_description, "
                    + "group_details.group_owner from group_details "
                    + "join group_member_list "
                    + "on group_details.group_id = group_member_list.group_id "
                    + "and group_member_list.member_id = ?;");
            ps.setInt(1, memberId);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                result.add(new GroupDetailsBean(rs));
            }
        }
        return result;
    }
    
    public ArrayList<GroupDetailsBean> getNonMemberGroups(int memberId) throws SQLException
    {
        ArrayList<GroupDetailsBean> result = new ArrayList<>();
        misc.DbConnect dbConnect = new misc.DbConnect();
        try (Connection myCon = dbConnect.getCon())
        {
            PreparedStatement ps = myCon.prepareStatement("select "
                    + "group_details.group_name, "
                    + "group_details.group_description, "
                    + "group_details.group_owner from group_details "
                    + "join group_member_list "
                    + "on group_details.group_id = group_member_list.group_id "
                    + "and group_member_list.member_id != ?;");
            ps.setInt(1, memberId);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                result.add(new GroupDetailsBean(rs));
            }
        }
        return result;
    }
}
