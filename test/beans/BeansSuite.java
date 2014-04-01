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
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Twiz
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(
{
    beans.GroupDetailsBeanTest.class, beans.MemberBeanTest.class, beans.GoalBeanTest.class, beans.LifeStyleBeanTest.class, beans.MessageDetailsBeanTest.class, beans.HealthyNormBeanTest.class, beans.MembersListBeanTest.class, beans.FoodBeanTest.class, beans.MessageRecipientsBeanTest.class, beans.HealthProfileBeanTest.class, beans.ExerciseBeanTest.class
})
public class BeansSuite
{

    @BeforeClass
    public static void setUpClass() throws Exception
    {
    }

    @AfterClass
    public static void tearDownClass() throws Exception
    {
    }

    @Before
    public void setUp() throws Exception
    {
    }

    @After
    public void tearDown() throws Exception
    {
    }
    
}
