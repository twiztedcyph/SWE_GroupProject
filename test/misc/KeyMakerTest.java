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
public class KeyMakerTest
{
    
    public KeyMakerTest()
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
     * Test of makeKeyDriver method, of class KeyMaker.
     */
    @Test
    public void testMakeKeyDriver()
    {
        System.out.println("makeKeyDriver");
        String key = "testing123";
        KeyMaker instance = new KeyMaker();
        byte[] expResult = {116,101,115,116,105,110,103,49,50,51,102,108,121,105,110,103};
        byte[] result = instance.makeKeyDriver(key);
        assertArrayEquals(expResult, result);
    }
}
