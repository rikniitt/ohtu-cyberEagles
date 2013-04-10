/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ViiteKirjaus.domain;

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
public class AttribuuttiTest {
    
    public AttribuuttiTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    Attribuutti a;
    
    @Before
    public void setUp() {
        a = new Attribuutti("year", "2013");
    }
    
    @After
    public void tearDown() {
    }
    
    public void konstruktoriToimii() {
        
        a = new Attribuutti("year", "2013");
        
        assertEquals("year", a.getNimi());
        assertEquals("2013", a.getArvo());
    }

    public void getNimiToimii() {
        
        assertEquals("year", a.getNimi());
    }
    
    public void getArvoToimii() {
        
        assertEquals("2013", a.getArvo());
        
    }
    
    public void toStringToimii() {
        
        assertEquals("2013", a.toString());
        
    }
}
