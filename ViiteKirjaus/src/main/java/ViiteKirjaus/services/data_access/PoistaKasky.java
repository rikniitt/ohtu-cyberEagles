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
public class PoistaKasky {
    
    private EbeanServer server;
    
    public PoistaKasky (EbeanServer server) {
        this.server = server;
    }
    
    public void viite(int id){
        new SqlViiteDao(server).delete(id);
    }
}
