/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
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
        String occupation = "Doctor";
        String[] hobbies = {"Reading", "Cooking"};
        int id = 5;
        LifeStyleBean instance = new LifeStyleBean(occupation, hobbies, id);
        String expResult = "Doctor";
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
        String userOccupation = "Nurse";
        String occupation = "Doctor";
        String[] hobbies = {"Reading", "Cooking"};
        int id = 5;
        LifeStyleBean instance = new LifeStyleBean(occupation, hobbies, id);
        instance.setUserOccupation(userOccupation);
        assertEquals(userOccupation, instance.getUserOccupation());
    }

    /**
     * Test of getUserHobbies method, of class LifeStyleBean.
     */
    @Test
    public void testGetUserHobbies()
    {
        System.out.println("getUserHobbies");
        String occupation = "Doctor";
        String[] hobbies = {"Reading", "Cooking"};
        int id = 5;
        LifeStyleBean instance = new LifeStyleBean(occupation, hobbies, id);
        String[] expResult = {"Reading", "Cooking"};
        String[] result = instance.getUserHobbies();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of setUserHobbies method, of class LifeStyleBean.
     */
    @Test
    public void testSetUserHobbies()
    {
        System.out.println("setUserHobbies");
        String[] userHobbies = {"Football", "Rugby"};
        String occupation = "Doctor";
        String[] hobbies = {"Reading", "Cooking"};
        int id = 5;
        LifeStyleBean instance = new LifeStyleBean(occupation, hobbies, id);
        instance.setUserHobbies(userHobbies);
        Assert.assertArrayEquals(userHobbies, instance.getUserHobbies());
    }

    /**
     * Test of getMemberId method, of class LifeStyleBean.
     */
    @Test
    public void testGetMemberId()
    {
        System.out.println("getMemberId");
        String occupation = "Doctor";
        String[] hobbies = {"Reading", "Cooking"};
        int id = 5;
        LifeStyleBean instance = new LifeStyleBean(occupation, hobbies, id);
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
        String occupation = "Doctor";
        String[] hobbies = {"Reading", "Cooking"};
        int id = 5;
        LifeStyleBean instance = new LifeStyleBean(occupation, hobbies, id);
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
        String occupation = "Doctor";
        String[] hobbies = {"Reading", "Cooking"};
        int id = 5;
        LifeStyleBean instance = new LifeStyleBean(occupation, hobbies, id);
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
        String occupation = "Doctor";
        String[] hobbies = {"Reading", "Cooking"};
        int id = 5;
        LifeStyleBean instance = new LifeStyleBean(occupation, hobbies, id);
        instance.persist();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
