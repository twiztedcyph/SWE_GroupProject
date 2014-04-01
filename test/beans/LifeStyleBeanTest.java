/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

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
public class LifeStyleBeanTest
{
    
    public LifeStyleBeanTest()
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
     * Test of getUserOccupation method, of class LifeStyleBean.
     */
    @Test
    public void testGetUserOccupation()
    {
        System.out.println("getUserOccupation");
        LifeStyleBean instance = new LifeStyleBean();
        String expResult = "";
        String result = instance.getUserOccupation();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUserOccupation method, of class LifeStyleBean.
     */
    @Test
    public void testSetUserOccupation()
    {
        System.out.println("setUserOccupation");
        String userOccupation = "";
        LifeStyleBean instance = new LifeStyleBean();
        instance.setUserOccupation(userOccupation);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserHobbies method, of class LifeStyleBean.
     */
    @Test
    public void testGetUserHobbies()
    {
        System.out.println("getUserHobbies");
        LifeStyleBean instance = new LifeStyleBean();
        String[] expResult = null;
        String[] result = instance.getUserHobbies();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUserHobbies method, of class LifeStyleBean.
     */
    @Test
    public void testSetUserHobbies()
    {
        System.out.println("setUserHobbies");
        String[] userHobbies = null;
        LifeStyleBean instance = new LifeStyleBean();
        instance.setUserHobbies(userHobbies);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMemberId method, of class LifeStyleBean.
     */
    @Test
    public void testGetMemberId()
    {
        System.out.println("getMemberId");
        LifeStyleBean instance = new LifeStyleBean();
        int expResult = 0;
        int result = instance.getMemberId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMemberId method, of class LifeStyleBean.
     */
    @Test
    public void testSetMemberId()
    {
        System.out.println("setMemberId");
        int memberId = 0;
        LifeStyleBean instance = new LifeStyleBean();
        instance.setMemberId(memberId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLifeStyle method, of class LifeStyleBean.
     */
    @Test
    public void testGetLifeStyle() throws Exception
    {
        System.out.println("getLifeStyle");
        int memberId = 0;
        LifeStyleBean instance = new LifeStyleBean();
        LifeStyleBean expResult = null;
        LifeStyleBean result = instance.getLifeStyle(memberId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of persist method, of class LifeStyleBean.
     */
    @Test
    public void testPersist() throws Exception
    {
        System.out.println("persist");
        LifeStyleBean instance = new LifeStyleBean();
        instance.persist();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
