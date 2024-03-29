/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package JoinedBeans;

import beans.MemberBean;
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
    private String text, subject;
    private Date sendDate;
    private Time sendTime;
    private boolean read, sent, group;
    int messageID;
    
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
            this.group = rs.getBoolean("isgroup");
            this.subject = rs.getString("subject");
            this.messageID = rs.getInt("messageid");
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

    public String getText()
    {
        return text;
    }

    public Date getSendDate()
    {
        return sendDate;
    }

    public Time getSendTime()
    {
        return sendTime;
    }


    public boolean isRead()
    {
        return read;
    }

    public boolean isSent()
    {
        return sent;
    }

    public boolean isGroup()
    {
        return group;
    }

    public String getSubject()
    {
        return subject;
    }

    public int getMessageID()
    {
        return messageID;
    }
    
    public String getSenderName() throws SQLException
    {
        return MemberBean.nameFromID(senderID);
        
    }
}
