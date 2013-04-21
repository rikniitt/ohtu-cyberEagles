/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ViiteKirjaus.services.data_access;

import ViiteKirjaus.domain.Viite;
import com.avaje.ebean.EbeanServer;

/**
 *
 * @author markus
 */
public class EtsiKasky {
    
    private EbeanServer server;
    
    public EtsiKasky(EbeanServer server) {
        this.server = server;
    }
    
    public Viite viite_jonka_id(int id){
        return server.find(Viite.class, id);
    }
}
