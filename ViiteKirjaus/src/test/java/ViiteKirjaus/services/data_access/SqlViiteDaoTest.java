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
    
    @Before
    public void setUp() {
        DB_config inMemoryTestCongig = new DB_configMemory(true, "sqlViiteDaoTestDb");
        testServer = inMemoryTestCongig.getServer();
        viiteDao = new SqlViiteDao(testServer);
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
//        for (Viite viite : viitteita) {
//            viiteDao.add(viite);
//        }
        InMemoryViiteDao testiViite = new InMemoryViiteDao();
        new SeedTestData().Nuket(testiViite);
        List<Viite> lista = viiteDao.listAll();
        assertTrue(testiViite.listAll().size() <= viiteDao.listAll().size());
    }
    
    @Test
    public void testListaaNimenMukaanEiLoydyNimella () {
        List<Viite> tyhjaLista = viiteDao.listByAuthor("Olematon Kirjailija");
        assertEquals(0, tyhjaLista.size());
    }
    
    @Test
    public void testListaaNimenMukaanYksiLoytyyNimella () {
        Attribuutti[] a = new Attribuutti[]{
                    new Attribuutti("publisher", "julkaisija"),
                    new Attribuutti("author", "asd5sdUNIQUEfASasdfds"),
                    new Attribuutti("year", "1900"),
                    new Attribuutti("title", "Kirja")
                };
        
        Viite k = new Viite("book", a);
        viiteDao.add(k);
        List<Viite> lista = viiteDao.listByAuthor("asd5sdUNIQUEfASasdfds");
        assertEquals(1, lista.size());
    }
    
    @Test
    public void testListaaNimenMukaanKolmeLoytyyNimella () {
        Attribuutti[] a = new Attribuutti[]{
                    new Attribuutti("publisher", "julkaisija"),
                    new Attribuutti("author", "kirjailija2"),
                    new Attribuutti("year", "1900"),
                    new Attribuutti("title", "Kirja1")
                };
        
        Viite k = new Viite("book", a);
        viiteDao.add(k);
        a = new Attribuutti[]{
                    new Attribuutti("publisher", "julkaisija"),
                    new Attribuutti("author", "kirjailija2"),
                    new Attribuutti("year", "1900"),
                    new Attribuutti("title", "Kirja2")
                };
        
        k = new Viite("book", a);
        viiteDao.add(k);
        a = new Attribuutti[]{
                    new Attribuutti("publisher", "julkaisija"),
                    new Attribuutti("author", "kirjailija2"),
                    new Attribuutti("year", "1900"),
                    new Attribuutti("title", "Kirja3")
                };
        
        k = new Viite("book", a);
        viiteDao.add(k);
        
        List<Viite> lista = viiteDao.listByAuthor("kirjailija2");
        assertEquals(3, lista.size());
    }
    
    @Test
    public void testPoistoIDllaJotaEiLoydy() {
        viiteDao.delete(Integer.MAX_VALUE);
    }
    
    
    @Test
    public void testYksiLisattyPoistonJalkeenListaaNimenMukaanEiLoydaYhtaan () {
        Attribuutti[] a = new Attribuutti[]{
                    new Attribuutti("publisher", "julkaisija"),
                    new Attribuutti("author", "kirjailija3"),
                    new Attribuutti("year", "1900"),
                    new Attribuutti("title", "Kirja")
                };
        
        Viite k = new Viite("book", a);
        viiteDao.add(k);
        viiteDao.delete(k.getId());
        List<Viite> lista = viiteDao.listByAuthor("kirjailija3");
        assertEquals(0, lista.size());
    }

    /**
     * Test of add method, of class SqlViiteDao.
     */
    
}
