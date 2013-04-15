/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data_acces;

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
        if (server == null) {
            server = initializeDatabase(dropAndCreateDatabase);
        }
    }

    @Override
    public EbeanServer getServer() {
        return server;
    }

    private EbeanServer initializeDatabase(boolean dropAndCreateDatabase) {
        ServerConfig config = new ServerConfig();
        config.setName("ViiteDb");
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

        return EbeanServerFactory.create(config);

    }
}