/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.sql.Date;
import java.sql.Time;
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
public class FoodBeanTest
{
    
    public FoodBeanTest()
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
     * Test of getFoodName method, of class FoodBean.
     */
    @Test
    public void testGetFoodName()
    {
        System.out.println("getFoodName");
        FoodBean instance = new FoodBean();
        String expResult = "";
        String result = instance.getFoodName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFoodName method, of class FoodBean.
     */
    @Test
    public void testSetFoodName()
    {
        System.out.println("setFoodName");
        String foodName = "";
        FoodBean instance = new FoodBean();
        instance.setFoodName(foodName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDateEaten method, of class FoodBean.
     */
    @Test
    public void testGetDateEaten()
    {
        System.out.println("getDateEaten");
        FoodBean instance = new FoodBean();
        Date expResult = null;
        Date result = instance.getDateEaten();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDateEaten method, of class FoodBean.
     */
    @Test
    public void testSetDateEaten()
    {
        System.out.println("setDateEaten");
        Date dateEaten = null;
        FoodBean instance = new FoodBean();
        instance.setDateEaten(dateEaten);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTimeEaten method, of class FoodBean.
     */
    @Test
    public void testGetTimeEaten()
    {
        System.out.println("getTimeEaten");
        FoodBean instance = new FoodBean();
        Time expResult = null;
        Time result = instance.getTimeEaten();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTimeEaten method, of class FoodBean.
     */
    @Test
    public void testSetTimeEaten()
    {
        System.out.println("setTimeEaten");
        Time timeEaten = null;
        FoodBean instance = new FoodBean();
        instance.setTimeEaten(timeEaten);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProteinPerHundredGrams method, of class FoodBean.
     */
    @Test
    public void testGetProteinPerHundredGrams()
    {
        System.out.println("getProteinPerHundredGrams");
        FoodBean instance = new FoodBean();
        double expResult = 0.0;
        double result = instance.getProteinPerHundredGrams();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProteinPerHundredGrams method, of class FoodBean.
     */
    @Test
    public void testSetProteinPerHundredGrams()
    {
        System.out.println("setProteinPerHundredGrams");
        double proteinPerHundredGrams = 0.0;
        FoodBean instance = new FoodBean();
        instance.setProteinPerHundredGrams(proteinPerHundredGrams);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCarbsPerHundredGrams method, of class FoodBean.
     */
    @Test
    public void testGetCarbsPerHundredGrams()
    {
        System.out.println("getCarbsPerHundredGrams");
        FoodBean instance = new FoodBean();
        double expResult = 0.0;
        double result = instance.getCarbsPerHundredGrams();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCarbsPerHundredGrams method, of class FoodBean.
     */
    @Test
    public void testSetCarbsPerHundredGrams()
    {
        System.out.println("setCarbsPerHundredGrams");
        double carbsPerHundredGrams = 0.0;
        FoodBean instance = new FoodBean();
        instance.setCarbsPerHundredGrams(carbsPerHundredGrams);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNonSatFatPerHundredGrams method, of class FoodBean.
     */
    @Test
    public void testGetNonSatFatPerHundredGrams()
    {
        System.out.println("getNonSatFatPerHundredGrams");
        FoodBean instance = new FoodBean();
        double expResult = 0.0;
        double result = instance.getNonSatFatPerHundredGrams();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNonSatFatPerHundredGrams method, of class FoodBean.
     */
    @Test
    public void testSetNonSatFatPerHundredGrams()
    {
        System.out.println("setNonSatFatPerHundredGrams");
        double NonSatFatPerHundredGrams = 0.0;
        FoodBean instance = new FoodBean();
        instance.setNonSatFatPerHundredGrams(NonSatFatPerHundredGrams);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSatFatPerHundredGrams method, of class FoodBean.
     */
    @Test
    public void testGetSatFatPerHundredGrams()
    {
        System.out.println("getSatFatPerHundredGrams");
        FoodBean instance = new FoodBean();
        double expResult = 0.0;
        double result = instance.getSatFatPerHundredGrams();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSatFatPerHundredGrams method, of class FoodBean.
     */
    @Test
    public void testSetSatFatPerHundredGrams()
    {
        System.out.println("setSatFatPerHundredGrams");
        double satFatPerHundredGrams = 0.0;
        FoodBean instance = new FoodBean();
        instance.setSatFatPerHundredGrams(satFatPerHundredGrams);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getKiloCalPerHundredGrams method, of class FoodBean.
     */
    @Test
    public void testGetKiloCalPerHundredGrams()
    {
        System.out.println("getKiloCalPerHundredGrams");
        FoodBean instance = new FoodBean();
        double expResult = 0.0;
        double result = instance.getKiloCalPerHundredGrams();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setKiloCalPerHundredGrams method, of class FoodBean.
     */
    @Test
    public void testSetKiloCalPerHundredGrams()
    {
        System.out.println("setKiloCalPerHundredGrams");
        double kiloCalPerHundredGrams = 0.0;
        FoodBean instance = new FoodBean();
        instance.setKiloCalPerHundredGrams(kiloCalPerHundredGrams);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSugarPerHundredGrams method, of class FoodBean.
     */
    @Test
    public void testGetSugarPerHundredGrams()
    {
        System.out.println("getSugarPerHundredGrams");
        FoodBean instance = new FoodBean();
        double expResult = 0.0;
        double result = instance.getSugarPerHundredGrams();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSugarPerHundredGrams method, of class FoodBean.
     */
    @Test
    public void testSetSugarPerHundredGrams()
    {
        System.out.println("setSugarPerHundredGrams");
        double sugarPerHundredGrams = 0.0;
        FoodBean instance = new FoodBean();
        instance.setSugarPerHundredGrams(sugarPerHundredGrams);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSaltPerHundredGrams method, of class FoodBean.
     */
    @Test
    public void testGetSaltPerHundredGrams()
    {
        System.out.println("getSaltPerHundredGrams");
        FoodBean instance = new FoodBean();
        double expResult = 0.0;
        double result = instance.getSaltPerHundredGrams();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSaltPerHundredGrams method, of class FoodBean.
     */
    @Test
    public void testSetSaltPerHundredGrams()
    {
        System.out.println("setSaltPerHundredGrams");
        double saltPerHundredGrams = 0.0;
        FoodBean instance = new FoodBean();
        instance.setSaltPerHundredGrams(saltPerHundredGrams);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMemberId method, of class FoodBean.
     */
    @Test
    public void testGetMemberId()
    {
        System.out.println("getMemberId");
        FoodBean instance = new FoodBean();
        int expResult = 0;
        int result = instance.getMemberId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMemberId method, of class FoodBean.
     */
    @Test
    public void testSetMemberId()
    {
        System.out.println("setMemberId");
        int memberId = 0;
        FoodBean instance = new FoodBean();
        instance.setMemberId(memberId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class FoodBean.
     */
    @Test
    public void testToString()
    {
        System.out.println("toString");
        FoodBean instance = new FoodBean();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of persist method, of class FoodBean.
     */
    @Test
    public void testPersist() throws Exception
    {
        System.out.println("persist");
        FoodBean instance = new FoodBean();
        instance.persist();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFood method, of class FoodBean.
     */
    @Test
    public void testGetFood() throws Exception
    {
        System.out.println("getFood");
        int memberId = 0;
        FoodBean instance = new FoodBean();
        ArrayList<FoodBean> expResult = null;
        ArrayList<FoodBean> result = instance.getFood(memberId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
