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
public class MakeShaTest
{
    
    public MakeShaTest()
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
     * Test of makeHash method, of class MakeSha.
     */
    @Test
    public void testMakeHash()
    {
        System.out.println("makeHash");
        String password = "myPassword";
        MakeSha instance = new MakeSha();
        String expResult = "nHC0YIoHkMLAtRTGOIps6OGOhiATDMd7+/FO+nGNt/Gq3AAv2+dt3ldoTghCW7CQ1T4rpm/3wtuTpdXuz0wAMw==";
        String result = instance.makeHash(password);
        System.out.println(result);
        assertEquals(expResult, result);
    }
    
}
