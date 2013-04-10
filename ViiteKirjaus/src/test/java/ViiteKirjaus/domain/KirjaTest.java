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
        
        boolean toimii = true;
        
        if (!a[0].getNimi().equals(a[0].getNimi()))
            toimii = false;
        if (!a[1].getNimi().equals(a[1].getNimi()))
            toimii = false;
        if (!a[2].getNimi().equals(a[2].getNimi()))
            toimii = false;
        if (!a[3].getNimi().equals(a[3].getNimi()))
            toimii = false;
        if (!a[4].getNimi().equals(a[4].getNimi()))
            toimii = false;
            
            
        assertEquals(true, toimii);
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
        
        boolean attribuutitOikein = true;
        
        if (!a[0].getNimi().equals("id"))
            attribuutitOikein = false;
        if (!a[1].getNimi().equals("author"))
            attribuutitOikein = false;
        if (!a[2].getNimi().equals("title"))
            attribuutitOikein = false;
        if (!a[3].getNimi().equals("year"))
            attribuutitOikein = false;
        if (!a[4].getNimi().equals("publisher"))
            attribuutitOikein = false;
            
            
        assertEquals(true, attribuutitOikein);
    }
}
