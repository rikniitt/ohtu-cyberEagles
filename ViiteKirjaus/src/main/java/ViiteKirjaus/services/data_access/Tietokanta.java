/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ViiteKirjaus.services.data_access;

import com.avaje.ebean.EbeanServer;

/**
 *
 * @author markus
 */

public class Tietokanta {
    
    private EbeanServer server;
    
    public static Tietokanta muistissa() {
         return new Tietokanta(new DB_configMemory(true, "H2ViiteDB").getServer());
    }
    
    public static Tietokanta levylla() {
         return new Tietokanta(new DB_configMemory(true, "LiteViiteDb").getServer());
    }
    
    private Tietokanta (EbeanServer server){
        this.server = server;
    }
    
    public TallennaKasky tallenna() {
        return new TallennaKasky(server);
    }
    
    public PoistaKasky poista() {
        return new PoistaKasky(server);
    }
    
    public ListaaKasky listaa() {
        return new ListaaKasky(server);
    }
    
    public EtsiKasky etsi() {
        return new EtsiKasky(server);
    }
}
