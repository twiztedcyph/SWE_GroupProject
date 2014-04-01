/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package misc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
public class DbConnectTest
{
    
    public DbConnectTest()
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
     * Test of runUpdate method, of class DbConnect.
     */
    @Test
    public void testRunUpdate_String()
    {
        System.out.println("runUpdate");
        String update = "";
        DbConnect instance = new DbConnect();
        boolean expResult = false;
        boolean result = instance.runUpdate(update);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of runUpdate method, of class DbConnect.
     */
    @Test
    public void testRunUpdate_String_byteArr()
    {
        System.out.println("runUpdate");
        String update = "";
        byte[] image = null;
        DbConnect instance = new DbConnect();
        boolean expResult = false;
        boolean result = instance.runUpdate(update, image);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of runQuery method, of class DbConnect.
     */
    @Test
    public void testRunQuery()
    {
        System.out.println("runQuery");
        String query = "";
        DbConnect instance = new DbConnect();
        ResultSet expResult = null;
        ResultSet result = instance.runQuery(query);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of runSecQuery method, of class DbConnect.
     */
    @Test
    public void testRunSecQuery()
    {
        System.out.println("runSecQuery");
        PreparedStatement updateStatement = null;
        DbConnect instance = new DbConnect();
        ResultSet expResult = null;
        ResultSet result = instance.runSecQuery(updateStatement);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCon method, of class DbConnect.
     */
    @Test
    public void testGetCon()
    {
        System.out.println("getCon");
        DbConnect instance = new DbConnect();
        Connection expResult = null;
        Connection result = instance.getCon();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of runSecUpdate method, of class DbConnect.
     */
    @Test
    public void testRunSecUpdate()
    {
        System.out.println("runSecUpdate");
        String update = "";
        DbConnect instance = new DbConnect();
        boolean expResult = false;
        boolean result = instance.runSecUpdate(update);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
