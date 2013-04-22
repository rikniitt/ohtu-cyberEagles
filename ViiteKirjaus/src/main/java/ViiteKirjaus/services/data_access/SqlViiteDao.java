/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ViiteKirjaus.services.data_access;

import ViiteKirjaus.domain.Attribuutti;
import ViiteKirjaus.domain.Viite;
import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.FetchConfig;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author markusno
 */
public class SqlViiteDao implements ViiteDao {

    EbeanServer server;

    public SqlViiteDao(EbeanServer server) {
        this.server = server;
    }

    @Override
    public List<Viite> listAll() {
        return server.find(Viite.class).findList();
    }

    @Override
    public void add(Viite viite) {
        server.save(viite);
    }

    @Override
    public Viite findById(int id) {
        return server.find(Viite.class, id);
    }

    List<Viite> listByAuthor(String Author) {
        List<Attribuutti> attribuutit =  server.find(Attribuutti.class)
                .where()
                .like("nimi", "author")
                .like("arvo", Author)
                .findList();
        ArrayList<Viite> viitteet = new ArrayList<Viite>();
        for (Attribuutti attribuutti : attribuutit) {
            
            viitteet.add(attribuutti.getViite());
        }
        return viitteet;
    }

    void delete(Integer viitteenID) {
        Viite viite = findById(viitteenID);
        if (viite == null){
            return;
        }
        server.delete(viite);
    }
}
