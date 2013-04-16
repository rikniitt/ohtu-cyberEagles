/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ViiteKirjaus.services.data_access;

import ViiteKirjaus.domain.Viite;
import ViiteKirjaus.utils.SeedTestData;
import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.validation.AssertTrue;
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
        InMemoryViiteDao testiViite = new InMemoryViiteDao();
        new SeedTestData().Nuket(testiViite);
        viitteita = testiViite.getViitteet();
    }


    /**
     * Test of listAll method, of class SqlViiteDao.
     */
    @Test
    public void testAddYhdenLisaysJaHakuOnnistuu() {
        viiteDao.add(viitteita.get(0));
        assertTrue(viiteDao.findById(1).getId() == viitteita.get(0).getId());
    }
    


    /**
     * Test of add method, of class SqlViiteDao.
     */
    
}
