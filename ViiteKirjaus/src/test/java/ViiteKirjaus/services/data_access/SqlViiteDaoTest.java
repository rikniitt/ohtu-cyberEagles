/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ViiteKirjaus.services.data_access;

import ViiteKirjaus.domain.Attribuutti;
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
    public void testAddYhdenLisaysJaHakuOnnistuuIDGeneroituuOikein() {
        Attribuutti[] a = new Attribuutti[]{
                    new Attribuutti("publisher", "IEEE Computer Society"),
                    new Attribuutti("editor", "Abram, Aman and More, James W. and Bourgue Pierre and Dupuis Robert"),
                    new Attribuutti("year", "2004"),
                    new Attribuutti("title", "Guide to the Software Engineering Body of Knownledge")
                };
        
        Viite k = new Viite("book", a);
        viiteDao.add(k);
        assertTrue(k.getId() == viiteDao.findById(k.getId()).getId());
    }
    
    @Test
    public void testLisaaMontaJaListaaKaikki() {
        for (Viite viite : viitteita) {
            viiteDao.add(viite);
        }
        List<Viite> lista = viiteDao.listAll();
        assertTrue(lista.size() == viitteita.size() + 1);
    }
    


    /**
     * Test of add method, of class SqlViiteDao.
     */
    
}
