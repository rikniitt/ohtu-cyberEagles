
package ViiteKirjaus.services.data_access;

import ViiteKirjaus.domain.Viite;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class InMemoryViiteDao implements ViiteDao{

    private List<Viite> viitteet;

    public InMemoryViiteDao() {
        viitteet = new ArrayList<Viite>();
    }
    
    
    
    @Override
    public void add(Viite viite) {
        viitteet.add(viite);
    }

    @Override
    public List<Viite> listAll() {
        return viitteet;
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
