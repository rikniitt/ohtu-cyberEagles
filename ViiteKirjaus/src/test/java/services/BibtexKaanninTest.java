/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import ViiteKirjaus.domain.Viite;
import ViiteKirjaus.domain.Attribuutti;
import ViiteKirjaus.domain.Attribuutti;
import ViiteKirjaus.domain.Viite;
import ViiteKirjaus.services.BibtexKaannin;
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
    Viite k;
    BibtexKaannin bk;
    
    @Before
    public void setUp() {
        
        a = new Attribuutti[]{
                    new Attribuutti("id", "Pek123"),
                    new Attribuutti("author", "Pekka Joki"),
                    new Attribuutti("title", "joku raamattu"),
                    new Attribuutti("year", "1920"),
                    new Attribuutti("publisher", "WSOY"),
                    new Attribuutti("pages", "123-124")};
                
        k = new Viite("book", a);
        
        bk = new BibtexKaannin();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void kaannaToimii() {
        
        assertEquals(
                "@book{P20,\n" +
                "    author = {Pekka Joki},\n" +
                "    title = {joku raamattu},\n" +
                "    year = {1920},\n" +
                "    publisher = {WSOY},\n" +
                "    pages = {123--124},\n" +
                "}"
                , bk.kaanna(k));
    }
    
    @Test
    public void kaannaSivuAttribuuttiToimii() {
        
        String s = "12--23";
        String s2 = "12-23";
        
        assertEquals("12--23", bk.kaannaSivuAttribuuttiOikein(s));
        assertEquals("12--23", bk.kaannaSivuAttribuuttiOikein(s2));
    }
    
    @Test
    public void toimiiVaikkaIdEiAnnetaEnsimmaisena() {
        
        a = new Attribuutti[]{
                    new Attribuutti("author", "Pekka Joki"),
                    new Attribuutti("title", "joku raamattu"),
                    new Attribuutti("year", "1920"),
                    new Attribuutti("publisher", "WSOY"),
                    new Attribuutti("pages", "123-124"),
                    new Attribuutti("id", "Pek123")};
                
        k = new Viite("book", a);
        
        assertEquals(
                "@book{P20,\n" +
                "    author = {Pekka Joki},\n" +
                "    title = {joku raamattu},\n" +
                "    year = {1920},\n" +
                "    publisher = {WSOY},\n" +
                "    pages = {123--124},\n" +
                "}",
                bk.kaanna(k));
    }
    
    @Test
    public void testViitteellaOnIdAttribuuttiKaantamisenJalkeen() {
        Viite v = new Viite("book", new Attribuutti[]{
                    new Attribuutti("id", "AB12"),
                    new Attribuutti("author", "Samu Sankari"),
                    new Attribuutti("title", "Kvartaalitalouden vaikutukset 1970-luvulla rakennettujen lähiöiden arkkitehtuuriin."),
                    new Attribuutti("year", "2007"),
                    new Attribuutti("publisher", "Oy Paino Ab"),
                    new Attribuutti("pages", "121-207")
        });
        
        bk.kaanna(v);
        
        //assertEquals("AB12", v.getAttribuutti("id"));
       
        boolean loytyi = false;
        
        for (Attribuutti attr : v.getAttribuutit()) {
            if (attr.getNimi().equals("id")) {
                loytyi = true;
            }
        }
        assertTrue(loytyi);
    }
    
    @Test
    public void testViitteellaAttribuuttejaYhtamontaKaantamisenJalkeen() {
        Viite v = new Viite("book", new Attribuutti[]{
                    new Attribuutti("id", "AB12"),
                    new Attribuutti("author", "Samu Sankari"),
                    new Attribuutti("title", "Kvartaalitalouden vaikutukset 1970-luvulla rakennettujen lähiöiden arkkitehtuuriin."),
                    new Attribuutti("year", "2007"),
                    new Attribuutti("publisher", "Oy Paino Ab"),
                    new Attribuutti("pages", "121-207")
        });
        
        int attribuutteja = v.getAttribuutit().size();
        
        bk.kaanna(v);
        
        assertEquals(attribuutteja, v.getAttribuutit().size());
    }
    
}
