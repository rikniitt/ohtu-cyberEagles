/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data_acces;

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
public class ViiteDaoTest {
    
    public ViiteDaoTest() {
    }
    
    ViiteDao viiteDao;
    
    @Before
    public void setUp(){
        viiteDao = new ViiteDao();
    }

    @Test
    public void testSomeMethod() {
        assertFalse(viiteDao == null);
    }
}
