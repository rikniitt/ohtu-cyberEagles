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
        return new SqlViiteDao(server).listAll();
    }
    
    public List<Viite> viitteet_joissa_kirjailijana(String kirjailija) {
        return new SqlViiteDao(server).listByAuthor(kirjailija);
    }
}
