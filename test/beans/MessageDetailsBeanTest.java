/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.sql.Date;
import java.sql.Time;
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
public class MessageDetailsBeanTest
{
    
    public MessageDetailsBeanTest()
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
     * Test of getText method, of class MessageDetailsBean.
     */
    @Test
    public void testGetText()
    {
        System.out.println("getText");
        MessageDetailsBean instance = new MessageDetailsBean(7, "Hello, itsa me mario", "hai");
        String expResult = "Hello, itsa me mario";
        String result = instance.getText();
        assertEquals(expResult, result);
    }

    /**
     * Test of setText method, of class MessageDetailsBean.
     */
    @Test
    public void testSetText()
    {
        System.out.println("setText");
        String text = "New text ftw";
        MessageDetailsBean instance = new MessageDetailsBean(7, "Hello, itsa me mario", "hai");
        instance.setText(text);
        assertEquals(text, instance.getText());
    }

    /**
     * Test of getSendDate method, of class MessageDetailsBean.
     */
    @Test
    public void testGetSendDate()
    {
        System.out.println("getSendDate");
        MessageDetailsBean instance = new MessageDetailsBean(7, "Hello, itsa me mario", "hai");
        Date expResult = Date.valueOf("2014-01-01");
        instance.setSendDate(expResult);
        Date result = instance.getSendDate();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getSendTime method, of class MessageDetailsBean.
     */
    @Test
    public void testGetSendTime()
    {
        System.out.println("getSendTime");
        MessageDetailsBean instance = new MessageDetailsBean(7, "Hello, itsa me mario", "hai");
        Time expResult = Time.valueOf("12:00:00");
        instance.setSendTime(expResult);
        Time result = instance.getSendTime();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getSenderID method, of class MessageDetailsBean.
     */
    @Test
    public void testGetSenderID()
    {
        System.out.println("getSenderID");
        MessageDetailsBean instance = new MessageDetailsBean(7, "Hello, itsa me mario", "hai");
        int expResult = 7;
        int result = instance.getSenderID();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSenderID method, of class MessageDetailsBean.
     */
    @Test
    public void testSetSenderID()
    {
        System.out.println("setSenderID");
        int senderID = 0;
        MessageDetailsBean instance = new MessageDetailsBean(7, "Hello, itsa me mario", "hai");
        instance.setSenderID(senderID);
        assertEquals(senderID, instance.getSenderID());
    }

    /**
     * Test of getId method, of class MessageDetailsBean.
     */
    @Test
    public void testGetId()
    {
        System.out.println("getId");
        MessageDetailsBean instance = new MessageDetailsBean(7, "Hello, itsa me mario", "hai");
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class MessageDetailsBean.
     */
    @Test
    public void testSetId()
    {
        System.out.println("setId");
        int id = 5;
        MessageDetailsBean instance = new MessageDetailsBean(7, "Hello, itsa me mario", "hai");
        instance.setId(id);
        assertEquals(id, instance.getId());
    }
    
}
