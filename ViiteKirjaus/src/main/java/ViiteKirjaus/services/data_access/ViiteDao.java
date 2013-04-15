package ViiteKirjaus.services.data_access;


import ViiteKirjaus.domain.Viite;
import java.util.List;


public interface ViiteDao {
    List<Viite> listAll();

    void add(Viite viite);
 
    Viite findById(int id);

}