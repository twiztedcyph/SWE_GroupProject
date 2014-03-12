/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Cypher
 */
public class MemberBean implements Serializable
{
    private int id;
    private String userName, password, firstName, lastName, emailAddress, accessType;
    private Date dateOfBirth;

    public MemberBean(){}
    
    public MemberBean(ResultSet rs) throws SQLException
    {
        this.id = rs.getInt("id");
        this.userName = rs.getString("user_name");
        this.password = rs.getString("password");
        this.firstName = rs.getString("first_name");
        this.lastName = rs.getString("last_name");
        this.emailAddress = rs.getString("email_address");
        this.accessType = rs.getString("access_type");
        this.dateOfBirth = rs.getDate("date_of_birth");
    }
    
    public MemberBean(String userName, String password, String firstName, String lastName, String emailAddress, String accessType, Date dateOfBirth)
    {
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.accessType = accessType;
        this.dateOfBirth = dateOfBirth;
    }
    
    public void persist() throws SQLException
    {
        misc.DbConnect dbConnect = new misc.DbConnect();
        
        Connection myCon = dbConnect.getCon();
        
        PreparedStatement ps = myCon.prepareStatement("INSERT INTO member (user_name, password, first_name, last_name, email_address, date_of_birth, access_type) values(?, ?, ?, ?, ?, ?, ?)");
        
        ps.setString(1, userName);
        ps.setString(2, password);
        ps.setString(3, firstName);
        ps.setString(4, lastName);
        ps.setString(5, emailAddress);
        ps.setDate(6, dateOfBirth);
        ps.setString(7, accessType);
        
        ps.executeUpdate();
    }
    
    public MemberBean retrieveOne(String username) throws SQLException
    {
        misc.DbConnect dbConnect = new misc.DbConnect();
        
        Connection myCon = dbConnect.getCon();
        
        PreparedStatement ps = myCon.prepareStatement("Select * from member where user_name = ?");
        ps.setString(1, username);
        
        
        return new MemberBean(ps.executeQuery());
    }
    
    public int getId()
    {
        return id;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getEmailAddress()
    {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress)
    {
        this.emailAddress = emailAddress;
    }

    public String getAccessType()
    {
        return accessType;
    }

    public void setAccessType(String accessType)
    {
        this.accessType = accessType;
    }
    
    public Date getDateOfBirth()
    {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
    }
}
