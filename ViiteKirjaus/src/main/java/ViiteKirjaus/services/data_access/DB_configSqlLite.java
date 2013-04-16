/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ViiteKirjaus.services.data_access;

import ViiteKirjaus.domain.Attribuutti;
import ViiteKirjaus.domain.Viite;
import com.avaje.ebean.Ebean;
import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.EbeanServerFactory;
import com.avaje.ebean.Transaction;
import com.avaje.ebean.config.DataSourceConfig;
import com.avaje.ebean.config.ServerConfig;
import com.avaje.ebean.config.dbplatform.SQLitePlatform;

/**
 *
 * @author markusno
 */
public class DB_configSqlLite implements DB_config {

    private static EbeanServer server;

    public DB_configSqlLite(boolean dropAndCreateDatabase) {
        this(dropAndCreateDatabase, "viitekanta");
    }
    
    public DB_configSqlLite(boolean dropAndCreateDatabase, String dbName) {
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

        DataSourceConfig sqLite = new DataSourceConfig();
        sqLite.setDriver("org.sqlite.JDBC");
        sqLite.setUsername("cyberEagles");
        sqLite.setPassword("cyberEagles");
        //sqLite.setUrl("jdbc:sqlite:/home/mluukkai/sqlite/kannat/beer.db");
        sqLite.setUrl("jdbc:sqlite:" + dbName + ".db");
        config.setDataSourceConfig(sqLite);
        config.setDatabasePlatform(new SQLitePlatform());
        config.getDataSourceConfig().setIsolationLevel(Transaction.READ_UNCOMMITTED);

        config.setDefaultServer(false);
        config.setRegister(false);

        if (dropAndCreateDatabase) {
            config.setDdlGenerate(true);
            config.setDdlRun(true);
            config.setDebugSql(true);
        }
        
//        config.addClass(Attribuutti.class);        
//        config.addClass(Viite.class);


        return EbeanServerFactory.create(config);
    }
}