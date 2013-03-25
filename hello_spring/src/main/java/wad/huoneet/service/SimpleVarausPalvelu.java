package wad.Varauset.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wad.huoneet.database.VarausDao;
import wad.huoneet.domain.Varaus;
import wad.huoneet.service.VarausPalvelu;


@Service
public class SimpleVarausPalvelu implements VarausPalvelu {

    @Autowired
    private VarausDao varausDao;
    
    
    @Override
    @Transactional
    public void lisaa(Varaus varaus) {
        varausDao.create(varaus);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Varaus> listaa() {
        return varausDao.list();
    }

    @Override
    @Transactional
    public void poista(int varausId) {
        Varaus v = varausDao.read(varausId);
        if (v != null) {
            varausDao.delete(v);
        }
    }
    
    
}
