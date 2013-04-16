
package ViiteKirjaus.services.data_access;

import ViiteKirjaus.domain.Viite;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class InMemoryViiteDao implements ViiteDao{

    private List<Viite> viitteet;
    
    private int id;

    public InMemoryViiteDao() {
        viitteet = new ArrayList<Viite>();
        id = 100;
    }
    
    
    
    @Override
    public void add(Viite viite) {
        viite.setId( seuraavaId() );
        viitteet.add(viite);
    }

    @Override
    public List<Viite> listAll() {
        return viitteet;
    }

    
    private int seuraavaId() {
        return id++;
    }

    
    
    public List<Viite> getViitteet() {
        return viitteet;
    }

    public void setViitteet(List<Viite> viitteet) {
        this.viitteet = viitteet;
    }

    @Override
    public Viite findById(int id) {
        for (Viite v : viitteet)
            if (v.getId() == id)
                return v;
        return null;
    }

    
    
    
    
    
}
