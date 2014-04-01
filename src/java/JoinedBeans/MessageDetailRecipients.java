/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package JoinedBeans;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import javax.servlet.ServletException;
import misc.DbConnect;
/**
 *
 * @author Liam
 */
public class MessageDetailRecipients implements Serializable
{
    private int senderID;
    private String text;
    private Date sendDate;
    private Time sendTime;
    private boolean read, sent, isGroup;
    
    public MessageDetailRecipients()
    {
        
    }
    
    public MessageDetailRecipients(ResultSet rs) throws SQLException
    {

            this.senderID = rs.getInt("senderid");
            this.text = rs.getString("text");
            this.sendDate = rs.getDate("send_date");
            this.sendTime = rs.getTime("send_time");
            this.read = rs.getBoolean("read");
            this.sent = rs.getBoolean("sent");
            this.isGroup = rs.getBoolean("isgroup");
    }
    
    public static ArrayList getMyRead(int userID, boolean read)
    {
        ArrayList messageList = new ArrayList();
        try
        {
           DbConnect databaseConnection = new DbConnect();
            Connection con = databaseConnection.getCon();
            
            PreparedStatement messagePS = con.prepareStatement(
                    "SELECT * FROM message_details JOIN message_recipients"
                            + " ON message_recipients.messageID = message_details.id "
                            + "WHERE message_recipients.recipientid =? AND"
                            + " message_recipients.read =?;");
            
            messagePS.setInt(1, userID);
            messagePS.setBoolean(2, read);
            ResultSet rs = messagePS.executeQuery();
            
            while(rs.next())
            {
               MessageDetailRecipients message = new MessageDetailRecipients(rs);
               messageList.add(message);
            }
            
            con.close();
        }
       catch(Exception e)
       {
          System.out.println("Read message method error"+e);
       }
        
       return messageList;
    } 

    public int getSenderID()
    {
        return senderID;
    }

    public void setSenderID(int senderID)
    {
        this.senderID = senderID;
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

    public boolean isRead()
    {
        return read;
    }

    public void setRead(boolean read)
    {
        this.read = read;
    }

    public boolean isSent()
    {
        return sent;
    }

    public void setSent(boolean sent)
    {
        this.sent = sent;
    }

    public boolean isIsGroup()
    {
        return isGroup;
    }

    public void setIsGroup(boolean isGroup)
    {
        this.isGroup = isGroup;
    }
}
