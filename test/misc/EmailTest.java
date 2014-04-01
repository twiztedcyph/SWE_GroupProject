/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package misc;

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
public class EmailTest
{
    
    public EmailTest()
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
     * Test of sendEmail method, of class Email.
     */
    @Test
    public void testSendEmail()
    {
        System.out.println("sendEmail");
        Email instance = null;
        instance.sendEmail();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validateEmail method, of class Email.
     */
    @Test
    public void testValidateEmail()
    {
        System.out.println("validateEmail");
        String emailAddress = "";
        boolean expResult = false;
        boolean result = Email.validateEmail(emailAddress);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
