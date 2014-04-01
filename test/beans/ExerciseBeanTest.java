/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.sql.Date;
import java.sql.SQLException;
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
public class ExerciseBeanTest
{
    
    public ExerciseBeanTest()
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
     * Test of persist method, of class ExerciseBean.
     */
    @Test
    public void testPersist() throws Exception
    {
        System.out.println("persist");
        ExerciseBean instance = new ExerciseBean("Pushups", "low", Date.valueOf("2014-04-01"), Time.valueOf("10:00:00"), 10, 5);
        try
        {
            instance.persist();
        }catch (SQLException e)
        {
            fail("An exception was thrown.");
        }
        assertTrue(true);
    }

    /**
     * Test of getExerciseType method, of class ExerciseBean.
     */
    @Test
    public void testGetExerciseType()
    {
        System.out.println("getExerciseType");
        ExerciseBean instance = new ExerciseBean("Pushups", "low", Date.valueOf("2014-04-01"), Time.valueOf("10:00:00"), 10, 5);
        String expResult = "Pushups";
        String result = instance.getExerciseType();
        assertEquals(expResult, result);
    }

    /**
     * Test of setExerciseType method, of class ExerciseBean.
     */
    @Test
    public void testSetExerciseType()
    {
        System.out.println("setExerciseType");
        String exerciseType = "Running";
        ExerciseBean instance = new ExerciseBean("Pushups", "low", Date.valueOf("2014-04-01"), Time.valueOf("10:00:00"), 10, 5);
        instance.setExerciseType(exerciseType);
        assertEquals(exerciseType, instance.getExerciseType());
    }

    /**
     * Test of getIntensity method, of class ExerciseBean.
     */
    @Test
    public void testGetIntensity()
    {
        System.out.println("getIntensity");
        ExerciseBean instance = new ExerciseBean("Pushups", "low", Date.valueOf("2014-04-01"), Time.valueOf("10:00:00"), 10, 5);
        String expResult = "low";
        String result = instance.getIntensity();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIntensity method, of class ExerciseBean.
     */
    @Test
    public void testSetIntensity()
    {
        System.out.println("setIntensity");
        String intensity = "high";
        ExerciseBean instance = new ExerciseBean("Pushups", "low", Date.valueOf("2014-04-01"), Time.valueOf("10:00:00"), 10, 5);
        instance.setIntensity(intensity);
        assertEquals(intensity, instance.getIntensity());
    }

    /**
     * Test of getExerciseDate method, of class ExerciseBean.
     */
    @Test
    public void testGetExerciseDate()
    {
        System.out.println("getExerciseDate");
        ExerciseBean instance = new ExerciseBean("Pushups", "low", Date.valueOf("2014-04-01"), Time.valueOf("10:00:00"), 10, 5);
        Date expResult = Date.valueOf("2014-04-01");
        Date result = instance.getExerciseDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of setExerciseDate method, of class ExerciseBean.
     */
    @Test
    public void testSetExerciseDate()
    {
        System.out.println("setExerciseDate");
        Date exerciseDate = Date.valueOf("1914-08-05");
        ExerciseBean instance = new ExerciseBean("Pushups", "low", Date.valueOf("2014-04-01"), Time.valueOf("10:00:00"), 10, 5);
        instance.setExerciseDate(exerciseDate);
        assertEquals(exerciseDate, instance.getExerciseDate());
    }

    /**
     * Test of getExerciseTime method, of class ExerciseBean.
     */
    @Test
    public void testGetExerciseTime()
    {
        System.out.println("getExerciseTime");
        ExerciseBean instance = new ExerciseBean("Pushups", "low", Date.valueOf("2014-04-01"), Time.valueOf("10:00:00"), 10, 5);
        Time expResult = Time.valueOf("10:00:00");
        Time result = instance.getExerciseTime();
        assertEquals(expResult, result);
    }

    /**
     * Test of setExerciseTime method, of class ExerciseBean.
     */
    @Test
    public void testSetExerciseTime()
    {
        System.out.println("setExerciseTime");
        Time exerciseTime = Time.valueOf("12:34:56");
        ExerciseBean instance = new ExerciseBean("Pushups", "low", Date.valueOf("2014-04-01"), Time.valueOf("10:00:00"), 10, 5);
        instance.setExerciseTime(exerciseTime);
        assertEquals(exerciseTime, instance.getExerciseTime());
    }

    /**
     * Test of getExerciseDuration method, of class ExerciseBean.
     */
    @Test
    public void testGetExerciseDuration()
    {
        System.out.println("getExerciseDuration");
        ExerciseBean instance = new ExerciseBean("Pushups", "low", Date.valueOf("2014-04-01"), Time.valueOf("10:00:00"), 10, 5);
        double expResult = 10;
        double result = instance.getExerciseDuration();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getId method, of class ExerciseBean.
     */
    @Test
    public void testGetId()
    {
        System.out.println("getId");
        ExerciseBean instance = new ExerciseBean("Pushups", "low", Date.valueOf("2014-04-01"), Time.valueOf("10:00:00"), 10, 5);
        int expResult = 5;
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setExerciseDuration method, of class ExerciseBean.
     */
    @Test
    public void testSetExerciseDuration()
    {
        System.out.println("setExerciseDuration");
        double exerciseDuration = 234;
        ExerciseBean instance = new ExerciseBean("Pushups", "low", Date.valueOf("2014-04-01"), Time.valueOf("10:00:00"), 10, 5);
        instance.setExerciseDuration(exerciseDuration);
        assertEquals(exerciseDuration, instance.getExerciseDuration(), 0.001);
    }

    /**
     * Test of deleteExercise method, of class ExerciseBean.
     */
    @Test
    public void testDeleteExercise() throws Exception
    {
        System.out.println("deleteExercise");
        int exerciseID = 0;
        int userID = 0;
        ExerciseBean.deleteExercise(exerciseID, userID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getExercise method, of class ExerciseBean.
     */
    @Test
    public void testGetExercise() throws Exception
    {
        System.out.println("getExercise");
        int memberId = 0;
        ExerciseBean instance = new ExerciseBean();
        ArrayList<ExerciseBean> result = instance.getExercise(memberId);
        assertNotNull(result);
        //assertTrue(result.size() > 0);
    }
    
}
