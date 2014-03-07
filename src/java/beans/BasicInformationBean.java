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
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Cypher
 */
public class BasicInformationBean implements Serializable
{
    private String userName, password, firstName, lastName, emailAddress, accesstype;;
    private Date dateOfBirth;
    private misc.EncyptDecrypt encDec = new misc.EncyptDecrypt();
    private misc.KeyMaker km = new misc.KeyMaker();
    private byte[] keyByte = km.makeKeyDriver("testingtestingonetwothree");
    private SecretKeySpec sks = new SecretKeySpec(keyByte, "AES");
    
    
    public BasicInformationBean(){}
    
    public BasicInformationBean(ResultSet rs)
    {
        try
        {
            this.firstName = encDec.decrypt(rs.getString("firstname"), sks);
            this.lastName = encDec.decrypt(rs.getString("lastname"), sks);
            this.userName = rs.getString("username");
            this.password = rs.getString("password");
            this.emailAddress = encDec.decrypt(rs.getString("email"), sks);
            this.accesstype = rs.getString("accesstype");
        } catch (SQLException sqle)
        {
            
        }
    }
    
    public BasicInformationBean(String username, String password, String firstname, String lastname, String email) throws SQLException, Exception
    {
        
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

    public Date getDateOfBirth()
    {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
    }
    public String getAccesstype()
    {
        return accesstype;
    }

    public void setAccesstype(String accesstype)
    {
        this.accesstype = accesstype;
    }
    public BasicInformationBean retrieveOne(String userName) throws SQLException
    {
        misc.DbConnect dbConnect = new misc.DbConnect();
        Connection myCon = dbConnect.getCon();
        PreparedStatement ps = myCon.prepareStatement("select * from users where username = ?");
        ps.setString(1, userName);
        
        BasicInformationBean results = null;
        
        ResultSet rs = ps.executeQuery();
        if(rs.next())
        {
            results = new BasicInformationBean(rs);
        }
        myCon.close();
        return results;
    }
}
