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
public class DB_configSqlLiteTest {

    public DB_configSqlLiteTest() {
    }
    
    DB_configSqlLite db_config;

    @Before
    public void setUp() {
            db_config = new DB_configSqlLite(true);       
    }

    @Test
    public void testKonstruktoriPalauttaaOlion() {
        assertFalse(false);
    }
}
