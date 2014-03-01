/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Cypher
 */
public class MessageDetailsBean implements Serializable
{
    private String messageText, messageType;
    private Date messageSendDate;
    private Time messageSendTime;
    private int messageSenderID, messageRecipientID;
    
    public MessageDetailsBean(){}

    public String getMessageText()
    {
        return messageText;
    }

    public void setMessageText(String messageText)
    {
        this.messageText = messageText;
    }

    public String getMessageType()
    {
        return messageType;
    }

    public void setMessageType(String messageType)
    {
        this.messageType = messageType;
    }

    public Date getMessageSendDate()
    {
        return messageSendDate;
    }

    public void setMessageSendDate(Date messageSendDate)
    {
        this.messageSendDate = messageSendDate;
    }

    public Time getMessageSendTime()
    {
        return messageSendTime;
    }

    public void setMessageSendTime(Time messageSendTime)
    {
        this.messageSendTime = messageSendTime;
    }

    public int getMessageSenderID()
    {
        return messageSenderID;
    }

    public void setMessageSenderID(int messageSenderID)
    {
        this.messageSenderID = messageSenderID;
    }

    public int getMessageRecipientID()
    {
        return messageRecipientID;
    }

    public void setMessageRecipientID(int messageRecipientID)
    {
        this.messageRecipientID = messageRecipientID;
    }
}
