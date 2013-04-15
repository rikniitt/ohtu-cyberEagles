
import com.avaje.ebean.EbeanServer;
import ViiteKirjaus.services.data_access.DB_configSqlLite;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author markusno
 */
public class Testausta {
    public static void main(String[] args) {
        DB_configSqlLite dbconf = new DB_configSqlLite(true);
        EbeanServer s = dbconf.getServer();
        System.out.println(dbconf != null);
        System.out.println(s != null);
    }
}
