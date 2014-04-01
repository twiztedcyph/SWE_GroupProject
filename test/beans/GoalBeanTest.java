/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.sql.Date;
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
     * Test of findByID method, of class GoalBean.
     */
    @Test
    public void testFindByID() throws Exception
    {
        System.out.println("findByID");
        int goalID = 0;
        GoalBean expResult = null;
        GoalBean result = GoalBean.findByID(goalID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class GoalBean.
     */
    @Test
    public void testToString()
    {
        System.out.println("toString");
        GoalBean instance = new GoalBean();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of persist method, of class GoalBean.
     */
    @Test
    public void testPersist() throws Exception
    {
        System.out.println("persist");
        GoalBean instance = new GoalBean();
        instance.persist();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSubmitter method, of class GoalBean.
     */
    @Test
    public void testGetSubmitter()
    {
        System.out.println("getSubmitter");
        GoalBean instance = new GoalBean();
        int expResult = 0;
        int result = instance.getSubmitter();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSubmitter method, of class GoalBean.
     */
    @Test
    public void testSetSubmitter()
    {
        System.out.println("setSubmitter");
        int submitter = 0;
        GoalBean instance = new GoalBean();
        instance.setSubmitter(submitter);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isGroupGoal method, of class GoalBean.
     */
    @Test
    public void testIsGroupGoal()
    {
        System.out.println("isGroupGoal");
        GoalBean instance = new GoalBean();
        boolean expResult = false;
        boolean result = instance.isGroupGoal();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGroupGoal method, of class GoalBean.
     */
    @Test
    public void testSetGroupGoal()
    {
        System.out.println("setGroupGoal");
        boolean groupGoal = false;
        GoalBean instance = new GoalBean();
        instance.setGroupGoal(groupGoal);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAim method, of class GoalBean.
     */
    @Test
    public void testGetAim()
    {
        System.out.println("getAim");
        GoalBean instance = new GoalBean();
        double expResult = 0.0;
        double result = instance.getAim();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAim method, of class GoalBean.
     */
    @Test
    public void testSetAim()
    {
        System.out.println("setAim");
        double aim = 0.0;
        GoalBean instance = new GoalBean();
        instance.setAim(aim);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCategory method, of class GoalBean.
     */
    @Test
    public void testGetCategory()
    {
        System.out.println("getCategory");
        GoalBean instance = new GoalBean();
        String expResult = "";
        String result = instance.getCategory();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCategory method, of class GoalBean.
     */
    @Test
    public void testSetCategory()
    {
        System.out.println("setCategory");
        String category = "";
        GoalBean instance = new GoalBean();
        instance.setCategory(category);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getType method, of class GoalBean.
     */
    @Test
    public void testGetType()
    {
        System.out.println("getType");
        GoalBean instance = new GoalBean();
        String expResult = "";
        String result = instance.getType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setType method, of class GoalBean.
     */
    @Test
    public void testSetType()
    {
        System.out.println("setType");
        String type = "";
        GoalBean instance = new GoalBean();
        instance.setType(type);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGoalStartDate method, of class GoalBean.
     */
    @Test
    public void testGetGoalStartDate()
    {
        System.out.println("getGoalStartDate");
        GoalBean instance = new GoalBean();
        Date expResult = null;
        Date result = instance.getGoalStartDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGoalStartDate method, of class GoalBean.
     */
    @Test
    public void testSetGoalStartDate()
    {
        System.out.println("setGoalStartDate");
        Date goalStartDate = null;
        GoalBean instance = new GoalBean();
        instance.setGoalStartDate(goalStartDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGoalEndDate method, of class GoalBean.
     */
    @Test
    public void testGetGoalEndDate()
    {
        System.out.println("getGoalEndDate");
        GoalBean instance = new GoalBean();
        Date expResult = null;
        Date result = instance.getGoalEndDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGoalEndDate method, of class GoalBean.
     */
    @Test
    public void testSetGoalEndDate()
    {
        System.out.println("setGoalEndDate");
        Date goalEndDate = null;
        GoalBean instance = new GoalBean();
        instance.setGoalEndDate(goalEndDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGoalProgress method, of class GoalBean.
     */
    @Test
    public void testGetGoalProgress()
    {
        System.out.println("getGoalProgress");
        GoalBean instance = new GoalBean();
        double expResult = 0.0;
        double result = instance.getGoalProgress();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGoalProgress method, of class GoalBean.
     */
    @Test
    public void testSetGoalProgress()
    {
        System.out.println("setGoalProgress");
        double goalProgress = 0.0;
        GoalBean instance = new GoalBean();
        instance.setGoalProgress(goalProgress);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getID method, of class GoalBean.
     */
    @Test
    public void testGetID()
    {
        System.out.println("getID");
        GoalBean instance = new GoalBean();
        int expResult = 0;
        int result = instance.getID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteGoal method, of class GoalBean.
     */
    @Test
    public void testDeleteGoal() throws Exception
    {
        System.out.println("deleteGoal");
        int goalID = 0;
        int userID = 0;
        GoalBean.deleteGoal(goalID, userID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateAim method, of class GoalBean.
     */
    @Test
    public void testUpdateAim() throws Exception
    {
        System.out.println("updateAim");
        int goalID = 0;
        Double aim = null;
        GoalBean.updateAim(goalID, aim);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateType method, of class GoalBean.
     */
    @Test
    public void testUpdateType() throws Exception
    {
        System.out.println("updateType");
        int goalID = 0;
        String type = "";
        GoalBean.updateType(goalID, type);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateCategory method, of class GoalBean.
     */
    @Test
    public void testUpdateCategory() throws Exception
    {
        System.out.println("updateCategory");
        int goalID = 0;
        String category = "";
        GoalBean.updateCategory(goalID, category);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateStartDate method, of class GoalBean.
     */
    @Test
    public void testUpdateStartDate() throws Exception
    {
        System.out.println("updateStartDate");
        int goalID = 0;
        Date startDate = null;
        GoalBean.updateStartDate(goalID, startDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateEndDate method, of class GoalBean.
     */
    @Test
    public void testUpdateEndDate() throws Exception
    {
        System.out.println("updateEndDate");
        int goalID = 0;
        Date endDate = null;
        GoalBean.updateEndDate(goalID, endDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
