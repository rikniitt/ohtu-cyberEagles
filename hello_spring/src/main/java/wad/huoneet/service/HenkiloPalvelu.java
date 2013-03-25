package wad.huoneet.service;

import java.util.List;
import wad.huoneet.domain.Henkilo;

public interface HenkiloPalvelu {

    public void lisaa(Henkilo henkilo);

    public List<Henkilo> listaa();

    public void poista(int henkiloId);
}
