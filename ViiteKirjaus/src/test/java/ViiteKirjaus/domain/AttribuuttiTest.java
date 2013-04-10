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
        
        Attribuutti att = new Attribuutti("year", "2013");
        
        boolean toimii = true;
        
        if (!att.getNimi().equals("year"))
            toimii = false;
        if (!att.getArvo().equals("2013"))
            toimii = false;
        
        assertEquals(true, toimii);
    }

    public void getNimiToimii() {
        
        boolean toimii = true;
        
        if (!a.getNimi().equals("year"))
            toimii = false;
        
        assertEquals(true, toimii);
    }
    
    public void getArvoToimii() {
        
        boolean toimii = true;
        
        if (!a.getArvo().equals("2013"))
            toimii = false;
        
        assertEquals(true, toimii);
    }
    
    public void toStringToimii() {
        
        boolean toimii = true;
        
        if (!a.toString().equals("2013"))
            toimii = false;
        
        assertEquals(true, toimii);
    }
}
