/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package JoinedBeans;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Twiz
 */
public class MessageDetailRecipientsTest
{
    
    public MessageDetailRecipientsTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
    }
    
    @After
    public void tearDown()
    {
    }

    /**
     * Test of getMyRead method, of class MessageDetailRecipients.
     */
    @Test
    public void testGetMyRead()
    {
        System.out.println("getMyRead");
        int userID = 0;
        boolean read = false;
        ArrayList expResult = null;
        ArrayList result = MessageDetailRecipients.getMyRead(userID, read);
        assertEquals(expResult, result);
    }

    /**
     * Test of getSenderID method, of class MessageDetailRecipients.
     */
    @Test
    public void testGetSenderID()
    {
        System.out.println("getSenderID");
        MessageDetailRecipients instance = new MessageDetailRecipients();
        int expResult = 0;
        int result = instance.getSenderID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSenderID method, of class MessageDetailRecipients.
     */
    @Test
    public void testSetSenderID()
    {
        System.out.println("setSenderID");
        int senderID = 0;
        MessageDetailRecipients instance = new MessageDetailRecipients();
        instance.setSenderID(senderID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getText method, of class MessageDetailRecipients.
     */
    @Test
    public void testGetText()
    {
        System.out.println("getText");
        MessageDetailRecipients instance = new MessageDetailRecipients();
        String expResult = "";
        String result = instance.getText();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setText method, of class MessageDetailRecipients.
     */
    @Test
    public void testSetText()
    {
        System.out.println("setText");
        String text = "";
        MessageDetailRecipients instance = new MessageDetailRecipients();
        instance.setText(text);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSendDate method, of class MessageDetailRecipients.
     */
    @Test
    public void testGetSendDate()
    {
        System.out.println("getSendDate");
        MessageDetailRecipients instance = new MessageDetailRecipients();
        Date expResult = null;
        Date result = instance.getSendDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSendDate method, of class MessageDetailRecipients.
     */
    @Test
    public void testSetSendDate()
    {
        System.out.println("setSendDate");
        Date sendDate = null;
        MessageDetailRecipients instance = new MessageDetailRecipients();
        instance.setSendDate(sendDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSendTime method, of class MessageDetailRecipients.
     */
    @Test
    public void testGetSendTime()
    {
        System.out.println("getSendTime");
        MessageDetailRecipients instance = new MessageDetailRecipients();
        Time expResult = null;
        Time result = instance.getSendTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSendTime method, of class MessageDetailRecipients.
     */
    @Test
    public void testSetSendTime()
    {
        System.out.println("setSendTime");
        Time sendTime = null;
        MessageDetailRecipients instance = new MessageDetailRecipients();
        instance.setSendTime(sendTime);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isRead method, of class MessageDetailRecipients.
     */
    @Test
    public void testIsRead()
    {
        System.out.println("isRead");
        MessageDetailRecipients instance = new MessageDetailRecipients();
        boolean expResult = false;
        boolean result = instance.isRead();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRead method, of class MessageDetailRecipients.
     */
    @Test
    public void testSetRead()
    {
        System.out.println("setRead");
        boolean read = false;
        MessageDetailRecipients instance = new MessageDetailRecipients();
        instance.setRead(read);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isSent method, of class MessageDetailRecipients.
     */
    @Test
    public void testIsSent()
    {
        System.out.println("isSent");
        MessageDetailRecipients instance = new MessageDetailRecipients();
        boolean expResult = false;
        boolean result = instance.isSent();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSent method, of class MessageDetailRecipients.
     */
    @Test
    public void testSetSent()
    {
        System.out.println("setSent");
        boolean sent = false;
        MessageDetailRecipients instance = new MessageDetailRecipients();
        instance.setSent(sent);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isIsGroup method, of class MessageDetailRecipients.
     */
    @Test
    public void testIsIsGroup()
    {
        System.out.println("isIsGroup");
        MessageDetailRecipients instance = new MessageDetailRecipients();
        boolean expResult = false;
        boolean result = instance.isIsGroup();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIsGroup method, of class MessageDetailRecipients.
     */
    @Test
    public void testSetIsGroup()
    {
        System.out.println("setIsGroup");
        boolean isGroup = false;
        MessageDetailRecipients instance = new MessageDetailRecipients();
        instance.setIsGroup(isGroup);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
