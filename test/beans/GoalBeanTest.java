/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.sql.Date;
import java.sql.SQLException;
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
public class GoalBeanTest
{
    
    public GoalBeanTest()
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
     * Test of persist method, of class GoalBean.
     */
    @Test
    public void testPersist() throws Exception
    {
        System.out.println("persist");
        GoalBean instance = new GoalBean(5, false,  
                    Date.valueOf("2014-04-01"), Date.valueOf("2014-05-01"), 12, 
                    "gain", "weight");
        try
        {
            instance.persist();
        } catch (SQLException e)
        {
            fail("An exception was thrown.");
        }
        assertTrue(true);
    }

    /**
     * Test of getSubmitter method, of class GoalBean.
     */
    @Test
    public void testGetSubmitter()
    {
        System.out.println("getSubmitter");
        GoalBean instance = new GoalBean(5, false, Date.valueOf("2014-04-01"), 
                Date.valueOf("2014-05-01"), 12, "gain", "weight");
        int expResult = 5;
        int result = instance.getSubmitter();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSubmitter method, of class GoalBean.
     */
    @Test
    public void testSetSubmitter()
    {
        System.out.println("setSubmitter");
        int submitter = 7;
        GoalBean instance = new GoalBean(5, false, Date.valueOf("2014-04-01"), 
                Date.valueOf("2014-05-01"), 12, "gain", "weight");
        instance.setSubmitter(submitter);
        assertEquals(submitter, instance.getSubmitter());
    }

    /**
     * Test of isGroupGoal method, of class GoalBean.
     */
    @Test
    public void testIsGroupGoal()
    {
        System.out.println("isGroupGoal");
        GoalBean instance = new GoalBean(5, false, Date.valueOf("2014-04-01"), 
                Date.valueOf("2014-05-01"), 12, "gain", "weight");
        boolean expResult = false;
        boolean result = instance.isGroupGoal();
        assertEquals(expResult, result);
    }

    /**
     * Test of setGroupGoal method, of class GoalBean.
     */
    @Test
    public void testSetGroupGoal()
    {
        System.out.println("setGroupGoal");
        boolean groupGoal = true;
        GoalBean instance = new GoalBean(5, false, Date.valueOf("2014-04-01"), 
                Date.valueOf("2014-05-01"), 12, "gain", "weight");
        instance.setGroupGoal(groupGoal);
        assertEquals(groupGoal, instance.isGroupGoal());
    }

    /**
     * Test of getAim method, of class GoalBean.
     */
    @Test
    public void testGetAim()
    {
        System.out.println("getAim");
        GoalBean instance = new GoalBean(5, false, Date.valueOf("2014-04-01"), 
                Date.valueOf("2014-05-01"), 12, "gain", "weight");
        double expResult = 12.0;
        double result = instance.getAim();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setAim method, of class GoalBean.
     */
    @Test
    public void testSetAim()
    {
        System.out.println("setAim");
        double aim = 7.0;
        GoalBean instance = new GoalBean(5, false, Date.valueOf("2014-04-01"), 
                Date.valueOf("2014-05-01"), 12, "gain", "weight");
        instance.setAim(aim);
        assertEquals(aim, instance.getAim(), 0.0);
    }

    /**
     * Test of getCategory method, of class GoalBean.
     */
    @Test
    public void testGetCategory()
    {
        System.out.println("getCategory");
        GoalBean instance = new GoalBean(5, false, Date.valueOf("2014-04-01"), 
                Date.valueOf("2014-05-01"), 12, "gain", "weight");
        String expResult = "gain";
        String result = instance.getCategory();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCategory method, of class GoalBean.
     */
    @Test
    public void testSetCategory()
    {
        System.out.println("setCategory");
        String category = "lose";
        GoalBean instance = new GoalBean(5, false, Date.valueOf("2014-04-01"), 
                Date.valueOf("2014-05-01"), 12, "gain", "weight");
        instance.setCategory(category);
        assertEquals(category, instance.getCategory());
    }

    /**
     * Test of getType method, of class GoalBean.
     */
    @Test
    public void testGetType()
    {
        System.out.println("getType");
        GoalBean instance = new GoalBean(5, false, Date.valueOf("2014-04-01"), 
                Date.valueOf("2014-05-01"), 12, "gain", "weight");
        String expResult = "weight";
        String result = instance.getType();
        assertEquals(expResult, result);
    }

    /**
     * Test of setType method, of class GoalBean.
     */
    @Test
    public void testSetType()
    {
        System.out.println("setType");
        String type = "Body Fat";
        GoalBean instance = new GoalBean(5, false, Date.valueOf("2014-04-01"), 
                Date.valueOf("2014-05-01"), 12, "gain", "weight");
        instance.setType(type);
        assertEquals(type, instance.getType());
    }

    /**
     * Test of getGoalStartDate method, of class GoalBean.
     */
    @Test
    public void testGetGoalStartDate()
    {
        System.out.println("getGoalStartDate");
        GoalBean instance = new GoalBean(5, false, Date.valueOf("2014-04-01"), 
                Date.valueOf("2014-05-01"), 12, "gain", "weight");
        Date expResult = Date.valueOf("2014-04-01");
        Date result = instance.getGoalStartDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of setGoalStartDate method, of class GoalBean.
     */
    @Test
    public void testSetGoalStartDate()
    {
        System.out.println("setGoalStartDate");
        Date goalStartDate = Date.valueOf("2000-07-03");
        GoalBean instance = new GoalBean(5, false, Date.valueOf("2014-04-01"), 
                Date.valueOf("2014-05-01"), 12, "gain", "weight");
        instance.setGoalStartDate(goalStartDate);
        assertEquals(goalStartDate, instance.getGoalStartDate());
    }

    /**
     * Test of getGoalEndDate method, of class GoalBean.
     */
    @Test
    public void testGetGoalEndDate()
    {
        System.out.println("getGoalEndDate");
        GoalBean instance = new GoalBean(5, false, Date.valueOf("2014-04-01"), 
                Date.valueOf("2014-05-01"), 12, "gain", "weight");
        Date expResult = Date.valueOf("2014-05-01");
        Date result = instance.getGoalEndDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of setGoalEndDate method, of class GoalBean.
     */
    @Test
    public void testSetGoalEndDate()
    {
        System.out.println("setGoalEndDate");
        Date goalEndDate = Date.valueOf("2014-06-03");
        GoalBean instance = new GoalBean(5, false, Date.valueOf("2014-04-01"), 
                Date.valueOf("2014-05-01"), 12, "gain", "weight");
        instance.setGoalEndDate(goalEndDate);
        assertEquals(goalEndDate, instance.getGoalEndDate());
    }

    /**
     * Test of getGoalProgress method, of class GoalBean.
     */
    @Test
    public void testGetGoalProgress()
    {
        System.out.println("getGoalProgress");
        GoalBean instance = new GoalBean(5, false, Date.valueOf("2014-04-01"), 
                Date.valueOf("2014-05-01"), 12, "gain", "weight");
        double expResult = 0.0;
        double result = instance.getGoalProgress();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setGoalProgress method, of class GoalBean.
     */
    @Test
    public void testSetGoalProgress()
    {
        System.out.println("setGoalProgress");
        double goalProgress = 23.0;
        GoalBean instance = new GoalBean(5, false, Date.valueOf("2014-04-01"), 
                Date.valueOf("2014-05-01"), 12, "gain", "weight");
        instance.setGoalProgress(goalProgress);
        assertEquals(goalProgress, instance.getGoalProgress(), 0.0);
    }
}
