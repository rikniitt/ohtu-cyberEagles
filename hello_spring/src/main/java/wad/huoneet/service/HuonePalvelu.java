package wad.huoneet.service;

import java.util.List;
import wad.huoneet.domain.Huone;

public interface HuonePalvelu {

    public void lisaa(Huone huone);

    public List<Huone> listaa();

    public void poista(int huoneId);
}
