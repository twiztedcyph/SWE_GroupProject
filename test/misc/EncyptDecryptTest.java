/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package misc;

import javax.crypto.spec.SecretKeySpec;
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
public class EncyptDecryptTest
{
    
    public EncyptDecryptTest()
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
     * Test of encrypt method, of class EncyptDecrypt.
     */
    @Test
    public void testEncrypt()
    {
        System.out.println("encrypt");
        String input = "";
        SecretKeySpec sks = null;
        EncyptDecrypt instance = new EncyptDecrypt();
        String expResult = "";
        String result = instance.encrypt(input, sks);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of decrypt method, of class EncyptDecrypt.
     */
    @Test
    public void testDecrypt()
    {
        System.out.println("decrypt");
        String input = "";
        SecretKeySpec sks = null;
        EncyptDecrypt instance = new EncyptDecrypt();
        String expResult = "";
        String result = instance.decrypt(input, sks);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
