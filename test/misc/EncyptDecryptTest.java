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
        String input = "Hello how are you?";
        KeyMaker km = new KeyMaker();
        SecretKeySpec sks = new SecretKeySpec(km.makeKeyDriver("myPassword"), "AES");
        EncyptDecrypt instance = new EncyptDecrypt();
        String expResult = "0fqylTncsgycZJQ+J5pS7v6/fj8M/fz4bavB/SnIBOQ=";
        String result = instance.encrypt(input, sks);
        assertEquals(expResult, result);
    }

    /**
     * Test of decrypt method, of class EncyptDecrypt.
     */
    @Test
    public void testDecrypt()
    {
        System.out.println("decrypt");
        String input = "0fqylTncsgycZJQ+J5pS7v6/fj8M/fz4bavB/SnIBOQ=";
        KeyMaker km = new KeyMaker();
        SecretKeySpec sks = new SecretKeySpec(km.makeKeyDriver("myPassword"), "AES");
        EncyptDecrypt instance = new EncyptDecrypt();
        String expResult = "Hello how are you?";
        String result = instance.decrypt(input, sks);
        assertEquals(expResult, result);
    }
    
}
