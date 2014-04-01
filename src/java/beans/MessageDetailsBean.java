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
import java.sql.Time;
import misc.DbConnect;

/**
 *
 * @author Cypher
 */
public class MessageDetailsBean implements Serializable
{
    private String text,subject;
    private Date sendDate;
    private Time sendTime;
    private int senderID;
    int id;
    
    public MessageDetailsBean(){}
    
    public MessageDetailsBean(int sender, String messageDetail, String givenSubject)
    {
        text = messageDetail;
        senderID = sender;
        subject = givenSubject;
    }

    public MessageDetailsBean(ResultSet rs) throws SQLException
    {
      this.id = rs.getInt("id");
      this.text = rs.getString("text");
      this.sendDate = rs.getDate("send_date");
      this.sendTime = rs.getTime("send_time");
      this.senderID = rs.getInt("senderid");
      this.subject = rs.getString("subject");
    }

     public int persist() throws SQLException
    {
       
            DbConnect databaseConnection = new DbConnect();
            Connection con = databaseConnection.getCon();
       
            PreparedStatement ps = con.prepareStatement("INSERT INTO message_details"
                                   + "(text, senderid, subject) VALUES(?,?,?) RETURNING id"); 
            
            ps.setString(1, text);
            ps.setInt(2, senderID);
            ps.setString(3, subject);
            ResultSet rs = ps.executeQuery();
            rs.next();
            
            int newMessageID = rs.getInt("id");
            
            con.close();
            
            return newMessageID;
    }
     
     public static MessageDetailsBean findByID(int givenMessageID) throws SQLException
     {
       DbConnect databaseConnection = new DbConnect();
            Connection con = databaseConnection.getCon();

        PreparedStatement ps = con.prepareStatement("Select * from message_details where id = ?");
        ps.setInt(1, givenMessageID);

        ResultSet rs = ps.executeQuery();
  
        rs.next();
        MessageDetailsBean returnMessage = new MessageDetailsBean(rs);
        
        con.close();
        
        return returnMessage;  
     }
    
    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public Date getSendDate()
    {
        return sendDate;
    }

    public void setSendDate(Date sendDate)
    {
        this.sendDate = sendDate;
    }

    public Time getSendTime()
    {
        return sendTime;
    }

    public void setSendTime(Time sendTime)
    {
        this.sendTime = sendTime;
    }

    public int getSenderID()
    {
        return senderID;
    }

    public void setSenderID(int senderID)
    {
        this.senderID = senderID;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getSubject()
    {
        return subject;
    }

    public void setSubject(String subject)
    {
        this.subject = subject;
    }
    
    
}
