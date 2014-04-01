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
public class HealthProfileBeanTest
{
    
    public HealthProfileBeanTest()
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
     * Test of getUserHeight method, of class HealthProfileBean.
     */
    @Test
    public void testGetUserHeight()
    {
        System.out.println("getUserHeight");
        HealthProfileBean instance = new HealthProfileBean();
        double expResult = 0.0;
        double result = instance.getUserHeight();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUserHeight method, of class HealthProfileBean.
     */
    @Test
    public void testSetUserHeight()
    {
        System.out.println("setUserHeight");
        double userHeight = 0.0;
        HealthProfileBean instance = new HealthProfileBean();
        instance.setUserHeight(userHeight);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserWeight method, of class HealthProfileBean.
     */
    @Test
    public void testGetUserWeight()
    {
        System.out.println("getUserWeight");
        HealthProfileBean instance = new HealthProfileBean();
        double expResult = 0.0;
        double result = instance.getUserWeight();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUserWeight method, of class HealthProfileBean.
     */
    @Test
    public void testSetUserWeight()
    {
        System.out.println("setUserWeight");
        double userWeight = 0.0;
        HealthProfileBean instance = new HealthProfileBean();
        instance.setUserWeight(userWeight);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserBMI method, of class HealthProfileBean.
     */
    @Test
    public void testGetUserBMI()
    {
        System.out.println("getUserBMI");
        HealthProfileBean instance = new HealthProfileBean();
        double expResult = 0.0;
        double result = instance.getUserBMI();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUserBMI method, of class HealthProfileBean.
     */
    @Test
    public void testSetUserBMI()
    {
        System.out.println("setUserBMI");
        double userBMI = 0.0;
        HealthProfileBean instance = new HealthProfileBean();
        instance.setUserBMI(userBMI);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserBodyFatPercent method, of class HealthProfileBean.
     */
    @Test
    public void testGetUserBodyFatPercent()
    {
        System.out.println("getUserBodyFatPercent");
        HealthProfileBean instance = new HealthProfileBean();
        double expResult = 0.0;
        double result = instance.getUserBodyFatPercent();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUserBodyFatPercent method, of class HealthProfileBean.
     */
    @Test
    public void testSetUserBodyFatPercent()
    {
        System.out.println("setUserBodyFatPercent");
        double userBodyFatPercent = 0.0;
        HealthProfileBean instance = new HealthProfileBean();
        instance.setUserBodyFatPercent(userBodyFatPercent);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRestingHeartRate method, of class HealthProfileBean.
     */
    @Test
    public void testGetRestingHeartRate()
    {
        System.out.println("getRestingHeartRate");
        HealthProfileBean instance = new HealthProfileBean();
        int expResult = 0;
        int result = instance.getRestingHeartRate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRestingHeartRate method, of class HealthProfileBean.
     */
    @Test
    public void testSetRestingHeartRate()
    {
        System.out.println("setRestingHeartRate");
        int restingHeartRate = 0;
        HealthProfileBean instance = new HealthProfileBean();
        instance.setRestingHeartRate(restingHeartRate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPeakHeartRate method, of class HealthProfileBean.
     */
    @Test
    public void testGetPeakHeartRate()
    {
        System.out.println("getPeakHeartRate");
        HealthProfileBean instance = new HealthProfileBean();
        int expResult = 0;
        int result = instance.getPeakHeartRate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPeakHeartRate method, of class HealthProfileBean.
     */
    @Test
    public void testSetPeakHeartRate()
    {
        System.out.println("setPeakHeartRate");
        int peakHeartRate = 0;
        HealthProfileBean instance = new HealthProfileBean();
        instance.setPeakHeartRate(peakHeartRate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
