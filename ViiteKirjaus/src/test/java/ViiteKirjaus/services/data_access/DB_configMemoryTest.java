/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ViiteKirjaus.services.data_access;

import ViiteKirjaus.services.data_access.DB_configMemory;
import ViiteKirjaus.services.data_access.DB_config;
import com.avaje.ebean.EbeanServer;
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
public class DB_configMemoryTest {

    public DB_configMemoryTest() {
    }
    
    DB_config db_config;
    EbeanServer server;

    @Before
    public void setUp() {
            db_config = new DB_configMemory(true, "testMemoryDb");
            server = db_config.getServer();
    }

    @Test
    public void testKonstruktoriPalauttaaOlion() {
        assertFalse(db_config == null);
    }
    
    @Test
    public void testGetServerPalauttaaOlion() {
        assertFalse(db_config.getServer() == null);
    }
    
    @Test
    public void testUusiConfiguraatioOlioPalauttaaSamanServerin(){
        DB_config newConfig = new DB_configMemory(true);
        assertTrue(newConfig.getServer().equals(server));
    }
}
