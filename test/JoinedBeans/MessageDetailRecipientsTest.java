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
}
