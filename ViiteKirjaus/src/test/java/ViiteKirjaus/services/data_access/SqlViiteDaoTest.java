/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ViiteKirjaus.services.data_access;

import ViiteKirjaus.domain.Viite;
import com.avaje.ebean.EbeanServer;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author markusno
 */
public class SqlViiteDaoTest {
    
    public SqlViiteDaoTest() {
    }

    EbeanServer testServer;
    SqlViiteDao viiteDao;
    
    @Before
    public void setUp() {
        DB_config inMemoryTestCongig = new DB_configMemory(true, "test");
        testServer = inMemoryTestCongig.getServer();
        viiteDao = new SqlViiteDao(testServer);
    }

    /**
     * Test of listAll method, of class SqlViiteDao.
     */
    @Test
    public void testListAll() {
        System.out.println("listAll");
        SqlViiteDao instance = null;
        List expResult = null;
        List result = instance.listAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class SqlViiteDao.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Viite viite = null;
        SqlViiteDao instance = null;
        instance.add(viite);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
