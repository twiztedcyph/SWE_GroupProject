/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.sql.Date;
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
public class MemberBeanTest
{
    
    public MemberBeanTest()
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
     * Test of setID method, of class MemberBean.
     */
    @Test
    public void testSetID()
    {
        System.out.println("setID");
        int givenID = 12;
        MemberBean instance = new MemberBean("testuser", "testpassword", "testfirst", "testlast", "testemail@test.test", "testaccess", Date.valueOf("2014-01-01"));
        instance.setID(givenID);
        assertEquals(givenID, instance.getId());
    }

    /**
     * Test of getId method, of class MemberBean.
     */
    @Test
    public void testGetId()
    {
        System.out.println("getId");
        MemberBean instance = new MemberBean("testuser", "testpassword", "testfirst", "testlast", "testemail@test.test", "testaccess", Date.valueOf("2014-01-01"));
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUserName method, of class MemberBean.
     */
    @Test
    public void testGetUserName()
    {
        System.out.println("getUserName");
        MemberBean instance = new MemberBean("testuser", "testpassword", "testfirst", "testlast", "testemail@test.test", "testaccess", Date.valueOf("2014-01-01"));
        String expResult = "testuser";
        String result = instance.getUserName();
        assertEquals(expResult, result);    }

    /**
     * Test of setUserName method, of class MemberBean.
     */
    @Test
    public void testSetUserName()
    {
        System.out.println("setUserName");
        String userName = "Amanda99";
        MemberBean instance = new MemberBean("testuser", "testpassword", "testfirst", "testlast", "testemail@test.test", "testaccess", Date.valueOf("2014-01-01"));
        instance.setUserName(userName);
        assertEquals(userName, instance.getUserName());
    }

    /**
     * Test of getPassword method, of class MemberBean.
     */
    @Test
    public void testGetPassword()
    {
        System.out.println("getPassword");
        MemberBean instance = new MemberBean("testuser", "testpassword", "testfirst", "testlast", "testemail@test.test", "testaccess", Date.valueOf("2014-01-01"));
        String expResult = "testpassword";
        String result = instance.getPassword();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPassword method, of class MemberBean.
     */
    @Test
    public void testSetPassword()
    {
        System.out.println("setPassword");
        String password = "newpassword";
        MemberBean instance = new MemberBean("testuser", "testpassword", "testfirst", "testlast", "testemail@test.test", "testaccess", Date.valueOf("2014-01-01"));
        instance.setPassword(password);
        assertEquals(password, instance.getPassword());
    }

    /**
     * Test of getFirstName method, of class MemberBean.
     */
    @Test
    public void testGetFirstName()
    {
        System.out.println("getFirstName");
        MemberBean instance = new MemberBean("testuser", "testpassword", "testfirst", "testlast", "testemail@test.test", "testaccess", Date.valueOf("2014-01-01"));
        String expResult = "testfirst";
        String result = instance.getFirstName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFirstName method, of class MemberBean.
     */
    @Test
    public void testSetFirstName()
    {
        System.out.println("setFirstName");
        String firstName = "newfirstname";
        MemberBean instance = new MemberBean("testuser", "testpassword", "testfirst", "testlast", "testemail@test.test", "testaccess", Date.valueOf("2014-01-01"));
        instance.setFirstName(firstName);
        assertEquals(firstName, instance.getFirstName());
    }

    /**
     * Test of getLastName method, of class MemberBean.
     */
    @Test
    public void testGetLastName()
    {
        System.out.println("getLastName");
        MemberBean instance = new MemberBean("testuser", "testpassword", "testfirst", "testlast", "testemail@test.test", "testaccess", Date.valueOf("2014-01-01"));
        String expResult = "testlast";
        String result = instance.getLastName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setLastName method, of class MemberBean.
     */
    @Test
    public void testSetLastName()
    {
        System.out.println("setLastName");
        String lastName = "newlastname";
        MemberBean instance = new MemberBean("testuser", "testpassword", "testfirst", "testlast", "testemail@test.test", "testaccess", Date.valueOf("2014-01-01"));
        instance.setLastName(lastName);
        assertEquals(lastName, instance.getLastName());
    }

    /**
     * Test of getEmailAddress method, of class MemberBean.
     */
    @Test
    public void testGetEmailAddress()
    {
        System.out.println("getEmailAddress");
        MemberBean instance = new MemberBean("testuser", "testpassword", "testfirst", "testlast", "testemail@test.test", "testaccess", Date.valueOf("2014-01-01"));
        String expResult = "";
        String result = instance.getEmailAddress();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmailAddress method, of class MemberBean.
     */
    @Test
    public void testSetEmailAddress()
    {
        System.out.println("setEmailAddress");
        String emailAddress = "";
        MemberBean instance = new MemberBean("testuser", "testpassword", "testfirst", "testlast", "testemail@test.test", "testaccess", Date.valueOf("2014-01-01"));
        instance.setEmailAddress(emailAddress);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAccessType method, of class MemberBean.
     */
    @Test
    public void testGetAccessType()
    {
        System.out.println("getAccessType");
        MemberBean instance = new MemberBean("testuser", "testpassword", "testfirst", "testlast", "testemail@test.test", "testaccess", Date.valueOf("2014-01-01"));
        String expResult = "";
        String result = instance.getAccessType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAccessType method, of class MemberBean.
     */
    @Test
    public void testSetAccessType()
    {
        System.out.println("setAccessType");
        String accessType = "";
        MemberBean instance = new MemberBean("testuser", "testpassword", "testfirst", "testlast", "testemail@test.test", "testaccess", Date.valueOf("2014-01-01"));
        instance.setAccessType(accessType);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDateOfBirth method, of class MemberBean.
     */
    @Test
    public void testGetDateOfBirth()
    {
        System.out.println("getDateOfBirth");
        MemberBean instance = new MemberBean("testuser", "testpassword", "testfirst", "testlast", "testemail@test.test", "testaccess", Date.valueOf("2014-01-01"));
        Date expResult = null;
        Date result = instance.getDateOfBirth();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDateOfBirth method, of class MemberBean.
     */
    @Test
    public void testSetDateOfBirth()
    {
        System.out.println("setDateOfBirth");
        Date dateOfBirth = null;
        MemberBean instance = new MemberBean("testuser", "testpassword", "testfirst", "testlast", "testemail@test.test", "testaccess", Date.valueOf("2014-01-01"));
        instance.setDateOfBirth(dateOfBirth);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changePassword method, of class MemberBean.
     */
    @Test
    public void testChangePassword() throws Exception
    {
        System.out.println("changePassword");
        String newPassword = "";
        MemberBean instance = new MemberBean("testuser", "testpassword", "testfirst", "testlast", "testemail@test.test", "testaccess", Date.valueOf("2014-01-01"));
        instance.changePassword(newPassword);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changeEmail method, of class MemberBean.
     */
    @Test
    public void testChangeEmail() throws Exception
    {
        System.out.println("changeEmail");
        String newEmail = "";
        MemberBean instance = new MemberBean("testuser", "testpassword", "testfirst", "testlast", "testemail@test.test", "testaccess", Date.valueOf("2014-01-01"));
        instance.changeEmail(newEmail);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGoalList method, of class MemberBean.
     */
    @Test
    public void testGetGoalList() throws Exception
    {
        System.out.println("getGoalList");
        MemberBean instance = new MemberBean("testuser", "testpassword", "testfirst", "testlast", "testemail@test.test", "testaccess", Date.valueOf("2014-01-01"));
        ArrayList<GoalBean> expResult = null;
        ArrayList<GoalBean> result = instance.getGoalList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGoalsInProgress method, of class MemberBean.
     */
    @Test
    public void testGetGoalsInProgress() throws Exception
    {
        System.out.println("getGoalsInProgress");
        MemberBean instance = new MemberBean("testuser", "testpassword", "testfirst", "testlast", "testemail@test.test", "testaccess", Date.valueOf("2014-01-01"));
        ArrayList<GoalBean> expResult = null;
        ArrayList<GoalBean> result = instance.getGoalsInProgress();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
