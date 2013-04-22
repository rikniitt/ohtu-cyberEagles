/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ViiteKirjaus.services.data_access;

import ViiteKirjaus.domain.Attribuutti;
import ViiteKirjaus.domain.Viite;
import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.EbeanServerFactory;
import com.avaje.ebean.config.DataSourceConfig;
import com.avaje.ebean.config.ServerConfig;

/**
 *
 * @author markusno
 */
public class DB_configMemory implements DB_config {

    private static EbeanServer server;

    public DB_configMemory(boolean dropAndCreateDatabase) {
        this(dropAndCreateDatabase, "viitekanta");
        
    }
    
    public DB_configMemory(boolean dropAndCreateDatabase, String dbName) {
        if (server == null) {
            server = initializeDatabase(dropAndCreateDatabase, dbName);
        }
    }

    @Override
    public EbeanServer getServer() {
        return server;
    }

    private EbeanServer initializeDatabase(boolean dropAndCreateDatabase, String dbName) {
        ServerConfig config = new ServerConfig();
        config.setName(dbName);
        DataSourceConfig hdDB = new DataSourceConfig();
        hdDB.setDriver("org.h2.Driver");
        hdDB.setUsername("test");
        hdDB.setPassword("test");
        hdDB.setUrl("jdbc:h2:mem:tests;DB_CLOSE_DELAY=-1");
        hdDB.setHeartbeatSql("select 1 ");
        config.setDataSourceConfig(hdDB);

        
        config.setDefaultServer(false);
        config.setRegister(false);

        if (dropAndCreateDatabase) {
            config.setDdlGenerate(true);
            config.setDdlRun(true);
            //config.setDebugSql(true);
        }
        
        config.addClass(Viite.class);
        config.addClass(Attribuutti.class);

        return EbeanServerFactory.create(config);

    }
}
