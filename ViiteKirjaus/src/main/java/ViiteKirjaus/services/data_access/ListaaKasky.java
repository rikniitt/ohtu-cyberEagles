/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ViiteKirjaus.services.data_access;

import ViiteKirjaus.domain.Viite;
import com.avaje.ebean.EbeanServer;
import java.util.List;

/**
 *
 * @author markus
 */
public class ListaaKasky {
    
    EbeanServer server;
    
    public ListaaKasky(EbeanServer server) {
        this.server = server;
    }
    
    public List<Viite> kaikki_viitteet() {
        return server.find(Viite.class).findList();
    }
}
