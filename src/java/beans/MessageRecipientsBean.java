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
import misc.DbConnect;

/**
 *
 * @author Cypher
 */
public class MessageRecipientsBean implements Serializable
{
  int messageID;
  int recipientID;
  boolean read;
  boolean sent;
  boolean isGroup;
  
  public MessageRecipientsBean(int givenMessageID, int givenRecipientID, 
                               boolean isSent, boolean group)
  {
      this.messageID = givenMessageID;
      this.recipientID = givenRecipientID;
      this.sent = isSent;
      this.isGroup = group;
  }
  
  public MessageRecipientsBean(ResultSet rs) throws SQLException
  {
    this.messageID = rs.getInt("messageID");
    this.recipientID = rs.getInt("recipientID");
    this.read = rs.getBoolean("read");
    this.sent = rs.getBoolean("sent");
    this.isGroup = rs.getBoolean("isgroup");
  }
  
  public void persist() throws SQLException
    {
       
            DbConnect databaseConnection = new DbConnect();
            Connection con = databaseConnection.getCon();
       
            PreparedStatement ps = con.prepareStatement("INSERT INTO message_recipients"
                                   + "(messageID, recipientID,sent, isGroup) "
                                    + "VALUES(?,?,?,?)"); 
            
            ps.setInt(1, messageID);
            ps.setInt(2, recipientID);
            ps.setBoolean(3, sent);
            ps.setBoolean(4, isGroup);
            
            ps.executeUpdate();
            
            con.close();
    }
}
