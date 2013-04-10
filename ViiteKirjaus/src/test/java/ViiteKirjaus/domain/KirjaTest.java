/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ViiteKirjaus.domain;

import ViiteKirjaus.domain.Kirja;
import ViiteKirjaus.domain.Attribuutti;
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
public class KirjaTest {
   
    public KirjaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void konstruktoriToimii() {
        
        Attribuutti[] a = new Attribuutti[]{
                    new Attribuutti("id", "Pek123"),
                    new Attribuutti("author", "Pekka Joki"),
                    new Attribuutti("title", "joku raamattu"),
                    new Attribuutti("year", "1920"),
                    new Attribuutti("publisher", "WSOY")};
                
        Kirja k = new Kirja(a);
        
        assertEquals(k.getAttribuutit()[0].getNimi(), a[0].getNimi());
        assertEquals(k.getAttribuutit()[1].getNimi(), a[1].getNimi());
        assertEquals(k.getAttribuutit()[2].getNimi(), a[2].getNimi());
        assertEquals(k.getAttribuutit()[3].getNimi(), a[3].getNimi());
        assertEquals(k.getAttribuutit()[4].getNimi(), a[4].getNimi());
    }
    
    @Test
    public void tyhjatAttribuutitKarsitaan() {
        
        Attribuutti[] a = new Attribuutti[]{
                    new Attribuutti("id", "Pek123"),
                    new Attribuutti("author", "Pekka Joki"),
                    new Attribuutti("title", "joku raamattu"),
                    new Attribuutti("year", "1920"),
                    new Attribuutti("publisher", " ")};
                
        Kirja k = new Kirja(a);
        
        assertEquals(4, k.getAttribuutit().length);
    }

    @Test
    public void getAttribuutit() {
        Kirja k =new Kirja(
                new Attribuutti[]{
                    new Attribuutti("id", "Pek123"),
                    new Attribuutti("author", "Pekka Joki"),
                    new Attribuutti("title", "joku raamattu"),
                    new Attribuutti("year", "1920"),
                    new Attribuutti("publisher", "WSOY")
                });
        Attribuutti[] a = k.getAttribuutit();
            
        assertEquals("id", a[0].getNimi());
        assertEquals("author", a[1].getNimi());
        assertEquals("title", a[2].getNimi());
        assertEquals("year", a[3].getNimi());
        assertEquals("publisher", a[4].getNimi());
    }
}
