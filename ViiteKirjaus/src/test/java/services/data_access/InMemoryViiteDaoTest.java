
package services.data_access;

import ViiteKirjaus.services.data_access.InMemoryViiteDao;
import ViiteKirjaus.domain.Attribuutti;
import ViiteKirjaus.domain.Viite;
import java.util.ArrayList;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;

public class InMemoryViiteDaoTest {
    
    public InMemoryViiteDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    InMemoryViiteDao dao;
    
    @Before
    public void setUp() {
        dao = new InMemoryViiteDao();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testLisaaViiteTyhjaan() {
        Viite v = new Viite("book", new Attribuutti[]{
                    new Attribuutti("id", "asg")});
        dao.add(v);     
        assertEquals(1, dao.listAll().size());

    }


    @Test
    public void testKonstruktoriLuoTyhjan() {
        assertEquals(0, dao.listAll().size());
    }


    
    @Test
    public void testListAllPalauttaaLisatyn() {
        Viite v = new Viite("book", new Attribuutti[]{
                    new Attribuutti("id", "asg")});
        dao.add(v);     
        
        
        assertEquals(v, dao.listAll().get(0));
    }


    
    
    @Test
    public void testAsetaViitteetOikeanKokoinen() {
        
        List<Viite> viitteet = new ArrayList<Viite>();
        Viite v = new Viite("book", new Attribuutti[]{
                    new Attribuutti("id", "asg")});
        
        viitteet.add(v);
        
        
        dao.setViitteet(viitteet);
        
        assertEquals(1, dao.listAll().size());
    }
    
    
    @Test
    public void testGetViitteetOikeanKokoinen() {
        
        List<Viite> viitteet = new ArrayList<Viite>();
        Viite v = new Viite("book", new Attribuutti[]{
                    new Attribuutti("id", "asg")});
        
        viitteet.add(v);
        
        
        dao.setViitteet(viitteet);
        
        assertEquals(1, dao.getViitteet().size());
    }
}
