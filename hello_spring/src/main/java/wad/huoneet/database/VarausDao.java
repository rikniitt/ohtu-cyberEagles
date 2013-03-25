
package wad.huoneet.database;

import java.util.List;
import wad.huoneet.domain.Varaus;


public interface VarausDao extends DAO<Varaus>{
    public List<Varaus> list();
}

