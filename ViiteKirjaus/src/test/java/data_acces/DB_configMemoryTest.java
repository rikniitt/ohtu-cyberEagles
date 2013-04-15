/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data_acces;

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

    @Before
    public void setUp() {
            db_config = new DB_configMemory(true);       
    }

    @Test
    public void testKonstruktoriPalauttaaOlion() {
        assertFalse(db_config == null);
    }
}
