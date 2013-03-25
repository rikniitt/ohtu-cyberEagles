package wad.huoneet.service;

import java.util.List;
import wad.huoneet.domain.Varaus;

public interface VarausPalvelu {

    public void lisaa(Varaus varaus);

    public List<Varaus> listaa();

    public void poista(int varausId);
}
