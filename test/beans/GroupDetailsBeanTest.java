/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

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
public class GroupDetailsBeanTest
{
    
    public GroupDetailsBeanTest()
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
     * Test of getGroupName method, of class GroupDetailsBean.
     */
    @Test
    public void testGetGroupName()
    {
        System.out.println("getGroupName");
        GroupDetailsBean instance = new GroupDetailsBean();
        String expResult = "";
        String result = instance.getGroupName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGroupName method, of class GroupDetailsBean.
     */
    @Test
    public void testSetGroupName()
    {
        System.out.println("setGroupName");
        String groupName = "";
        GroupDetailsBean instance = new GroupDetailsBean();
        instance.setGroupName(groupName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGroupDescription method, of class GroupDetailsBean.
     */
    @Test
    public void testGetGroupDescription()
    {
        System.out.println("getGroupDescription");
        GroupDetailsBean instance = new GroupDetailsBean();
        String expResult = "";
        String result = instance.getGroupDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGroupDescription method, of class GroupDetailsBean.
     */
    @Test
    public void testSetGroupDescription()
    {
        System.out.println("setGroupDescription");
        String groupDescription = "";
        GroupDetailsBean instance = new GroupDetailsBean();
        instance.setGroupDescription(groupDescription);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGroupOwner method, of class GroupDetailsBean.
     */
    @Test
    public void testGetGroupOwner()
    {
        System.out.println("getGroupOwner");
        GroupDetailsBean instance = new GroupDetailsBean();
        int expResult = 0;
        int result = instance.getGroupOwner();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGroupOwner method, of class GroupDetailsBean.
     */
    @Test
    public void testSetGroupOwner()
    {
        System.out.println("setGroupOwner");
        int groupOwner = 0;
        GroupDetailsBean instance = new GroupDetailsBean();
        instance.setGroupOwner(groupOwner);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMemberGroups method, of class GroupDetailsBean.
     */
    @Test
    public void testGetMemberGroups() throws Exception
    {
        System.out.println("getMemberGroups");
        int memberId = 0;
        GroupDetailsBean instance = new GroupDetailsBean();
        ArrayList<GroupDetailsBean> expResult = null;
        ArrayList<GroupDetailsBean> result = instance.getMemberGroups(memberId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllGroups method, of class GroupDetailsBean.
     */
    @Test
    public void testGetAllGroups() throws Exception
    {
        System.out.println("getAllGroups");
        GroupDetailsBean instance = new GroupDetailsBean();
        ArrayList<GroupDetailsBean> expResult = null;
        ArrayList<GroupDetailsBean> result = instance.getAllGroups();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOne method, of class GroupDetailsBean.
     */
    @Test
    public void testGetOne() throws Exception
    {
        System.out.println("getOne");
        String groupName = "";
        GroupDetailsBean instance = new GroupDetailsBean();
        GroupDetailsBean expResult = null;
        GroupDetailsBean result = instance.getOne(groupName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of persist method, of class GroupDetailsBean.
     */
    @Test
    public void testPersist() throws Exception
    {
        System.out.println("persist");
        GroupDetailsBean instance = new GroupDetailsBean();
        instance.persist();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
