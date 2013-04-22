/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ViiteKirjaus.services.data_access;

import ViiteKirjaus.domain.Attribuutti;
import ViiteKirjaus.domain.Viite;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author markusno
 */
public class TietokantaTest {

    public TietokantaTest() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void testMuistissaPalauttaaTietokantaOlion() {
        assertEquals(Tietokanta.class, Tietokanta.levylla().getClass());
    }

    /**
     * Test of levylla method, of class Tietokanta.
     */
    @Test
    public void testLevyllaPalauttaaTietokantaOlion() {
        assertEquals(Tietokanta.class, Tietokanta.muistissa().getClass());
    }

    /**
     * Test of tallenna method, of class Tietokanta.
     */
    @Test
    public void testTallennaPalauttaaTallennaKaskyOlion() {
        assertEquals(TallennaKasky.class, Tietokanta.muistissa().tallenna().getClass());
    }

    /**
     * Test of poista method, of class Tietokanta.
     */
    @Test
    public void testPoistaPalauttaaTallennaKaskyOlion() {
        assertEquals(PoistaKasky.class, Tietokanta.muistissa().poista().getClass());
    }

    /**
     * Test of listaa method, of class Tietokanta.
     */
    @Test
    public void testListaaPalauttaaListaaKaskyOlion() {
        assertEquals(ListaaKasky.class, Tietokanta.muistissa().listaa().getClass());
    }

    /**
     * Test of etsi method, of class Tietokanta.
     */
    @Test
    public void testEtsiPalauttaaEtsiKaskyOlion() {
        assertEquals(EtsiKasky.class, Tietokanta.muistissa().etsi().getClass());
    }

    @Test
    public void testTallennaViiteJaEtsiViiteJonkaIdToimii() {
        Attribuutti[] a = new Attribuutti[]{

                    new Attribuutti("publisher", "julkaisija"),
                    new Attribuutti("author", "author"),
                    new Attribuutti("year", "1900"),
                    new Attribuutti("title", "Kirja")
                };
        
        Viite k = new Viite("book", a);
        k.setId(1000);
        Tietokanta.muistissa().tallenna().viite(k);
        assertEquals(k.getId(), Tietokanta.muistissa().etsi().viite_jonka_id(1000).getId());
    }
    
    @Test
    public void testTallennaViiteJaListaaKaikkiViitteetToimii() {
        Attribuutti[] a = new Attribuutti[]{

                    new Attribuutti("publisher", "julkaisija"),
                    new Attribuutti("author", "author2"),
                    new Attribuutti("year", "1900"),
                    new Attribuutti("title", "Kirja")
                };
        
        Viite k = new Viite("book", a);
        Tietokanta.muistissa().tallenna().viite(k);
        assertEquals(1, Tietokanta.muistissa().listaa().viitteet_joissa_kirjailijana("author2").size());
    }
    
    @Test
    public void testTallennaViiteJaPoistaToimii() {
        Attribuutti[] a = new Attribuutti[]{

                    new Attribuutti("publisher", "julkaisija"),
                    new Attribuutti("author", "author2"),
                    new Attribuutti("year", "1900"),
                    new Attribuutti("title", "Kirja")
                };
        
        Viite k = new Viite("book", a);
        Tietokanta.muistissa().tallenna().viite(k);
        int id = k.getId();
        Tietokanta.muistissa().poista().viite(k.getId());
        assertEquals(null, Tietokanta.muistissa().etsi().viite_jonka_id(id));
    }
}
