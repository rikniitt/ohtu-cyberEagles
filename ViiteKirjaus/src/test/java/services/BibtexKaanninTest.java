/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import ViiteKirjaus.domain.Kirja;
import ViiteKirjaus.domain.Attribuutti;
import ViiteKirjaus.domain.Attribuutti;
import ViiteKirjaus.domain.Kirja;
import services.BibtexKaannin;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author olzraiti
 */
public class BibtexKaanninTest {
    
    public BibtexKaanninTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    Attribuutti[] a;
    Kirja k;
    BibtexKaannin bk;
    
    @Before
    public void setUp() {
        
        a = new Attribuutti[]{
                    new Attribuutti("id", "Pek123"),
                    new Attribuutti("author", "Pekka Joki"),
                    new Attribuutti("title", "joku raamattu"),
                    new Attribuutti("year", "1920"),
                    new Attribuutti("publisher", "WSOY")};
                
        k = new Kirja(a);
        
        bk = new BibtexKaannin();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testKaanna() {
        boolean toimii = true;
        
        if (!bk.kaanna(k).equals("@book{Pek123,\n" +
                                "author = Pekka Joki,\n" +
                                "title = joku raamattu,\n" +
                                "year = 1920,\n" +
                                "publisher = WSOY,\n" +
                                "}"))
                toimii = false;
        
        assertEquals(true, toimii);
    }
    
    @Test
    public void toimiiVaikkaIdEiAnnetaEnsimmaisena() {
        
        a = new Attribuutti[]{
                    new Attribuutti("id", "Pek123"),
                    new Attribuutti("author", "Pekka Joki"),
                    new Attribuutti("title", "joku raamattu"),
                    new Attribuutti("year", "1920"),
                    new Attribuutti("publisher", "WSOY"),
                    new Attribuutti("id", "Pek123")};
                
        k = new Kirja(a);
        
        
        boolean toimii = true;
        
        if (!bk.kaanna(k).equals("@book{Pek123,\n" +
                                "author = Pekka Joki,\n" +
                                "title = joku raamattu,\n" +
                                "year = 1920,\n" +
                                "publisher = WSOY,\n" +
                                "}"))
                toimii = false;
        
        assertEquals(true, toimii);
    }
}
