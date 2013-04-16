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
 * @author markusno
 */
public class SqlViiteDao implements ViiteDao{
    
    EbeanServer server;

    public SqlViiteDao(EbeanServer server) {
        this.server = server;
    }

    @Override
    public List<Viite> listAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void add(Viite viite) {
        server.save(viite);
    }

    @Override
    public Viite findById(int id) {
        return server.find(Viite.class, id);
    }
    
}
