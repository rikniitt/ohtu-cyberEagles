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
public class TallennaKasky {
    
    private EbeanServer server;
    
    public TallennaKasky (EbeanServer server) {
        this.server = server;
    }
    
    public void viite(Viite viite){
        new SqlViiteDao(server).add(viite);
    }
}
