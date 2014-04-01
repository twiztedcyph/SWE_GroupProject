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
     * Test of persist method, of class MessageDetailsBean.
     */
    @Test
    public void testPersist() throws Exception
    {
        System.out.println("persist");
        MessageDetailsBean instance = new MessageDetailsBean();
        int expResult = 0;
        int result = instance.persist();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getText method, of class MessageDetailsBean.
     */
    @Test
    public void testGetText()
    {
        System.out.println("getText");
        MessageDetailsBean instance = new MessageDetailsBean();
        String expResult = "";
        String result = instance.getText();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setText method, of class MessageDetailsBean.
     */
    @Test
    public void testSetText()
    {
        System.out.println("setText");
        String text = "";
        MessageDetailsBean instance = new MessageDetailsBean();
        instance.setText(text);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSendDate method, of class MessageDetailsBean.
     */
    @Test
    public void testGetSendDate()
    {
        System.out.println("getSendDate");
        MessageDetailsBean instance = new MessageDetailsBean();
        Date expResult = null;
        Date result = instance.getSendDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSendDate method, of class MessageDetailsBean.
     */
    @Test
    public void testSetSendDate()
    {
        System.out.println("setSendDate");
        Date sendDate = null;
        MessageDetailsBean instance = new MessageDetailsBean();
        instance.setSendDate(sendDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSendTime method, of class MessageDetailsBean.
     */
    @Test
    public void testGetSendTime()
    {
        System.out.println("getSendTime");
        MessageDetailsBean instance = new MessageDetailsBean();
        Time expResult = null;
        Time result = instance.getSendTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSendTime method, of class MessageDetailsBean.
     */
    @Test
    public void testSetSendTime()
    {
        System.out.println("setSendTime");
        Time sendTime = null;
        MessageDetailsBean instance = new MessageDetailsBean();
        instance.setSendTime(sendTime);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSenderID method, of class MessageDetailsBean.
     */
    @Test
    public void testGetSenderID()
    {
        System.out.println("getSenderID");
        MessageDetailsBean instance = new MessageDetailsBean();
        int expResult = 0;
        int result = instance.getSenderID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSenderID method, of class MessageDetailsBean.
     */
    @Test
    public void testSetSenderID()
    {
        System.out.println("setSenderID");
        int senderID = 0;
        MessageDetailsBean instance = new MessageDetailsBean();
        instance.setSenderID(senderID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class MessageDetailsBean.
     */
    @Test
    public void testGetId()
    {
        System.out.println("getId");
        MessageDetailsBean instance = new MessageDetailsBean();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class MessageDetailsBean.
     */
    @Test
    public void testSetId()
    {
        System.out.println("setId");
        int id = 0;
        MessageDetailsBean instance = new MessageDetailsBean();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
