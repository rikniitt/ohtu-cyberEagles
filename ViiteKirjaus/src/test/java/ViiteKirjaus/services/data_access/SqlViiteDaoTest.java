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
    List<Viite> viitteita;
    
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
    public void testAddYhdenLisaysOnnistuu() {
        assertTrue(true);
    }


    /**
     * Test of add method, of class SqlViiteDao.
     */
    
}
