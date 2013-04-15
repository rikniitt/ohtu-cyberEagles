package ViiteKirjaus.services;

import ViiteKirjaus.domain.Attribuutti;
import ViiteKirjaus.domain.Viite;
import java.util.List;

/**
 *
 * @author olzraiti
 */
public class BibtexKaannin {
    
    public static void main(String[] args) {

        Viite k = new Viite("book",
                new Attribuutti[]{
                    new Attribuutti("id", "Pek123"),
                    new Attribuutti("author", "Pekka Joki"),
                    new Attribuutti("title", "joku raamattu"),
                    new Attribuutti("year", "1920"),
                    new Attribuutti("publisher", "WSOY"),
                    new Attribuutti("asd", " "),
                    new Attribuutti("pages", "123-124")
                });
//
        BibtexKaannin b = new BibtexKaannin();
        String kkk = b.kaanna(k);
        System.out.println(kkk);
    }

    public String kaanna(Viite k) {
        String kaannos = "@" + k.getTyyppi() + "{";

        //IDn täytyy olla ensimmäisenä
        List<Attribuutti> atribuutit = k.getAttribuutit();

        for (int i = 0; i < atribuutit.size(); i++) {
            Attribuutti a = atribuutit.get(i);
            if (a.getNimi().equals("id")) {
                kaannos += a.toString() + ",\n";
                atribuutit.remove(a);
                break;
            }
        }

        //muiden attribuuttien järjestyksellä ei väliä
        for (int i = 0; i < atribuutit.size(); i++) {
            Attribuutti a = atribuutit.get(i);
            kaannos += a.getNimi() + " = {";
            if (a.getNimi().equals("pages")) {                               //käännetään sivuattribuutti oikeaan muotoon
                kaannos += kaannaSivuAttribuuttiOikein(a.getArvo()) + "},\n";
            } else {
                kaannos += a +  "},\n";
            }
        }

        kaannos = kaannos + "}";



        return kaannos;
    }

    public String kaannaSivuAttribuuttiOikein(String s) {
        String korjattu = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '-') {
                if (s.charAt(i + 1) != '-') {
                    for (int j = 0; j < s.length(); j++) {
                        if (j == i) {
                            korjattu += "-";
                        }
                        korjattu += s.charAt(j);
                    }
                } else {
                    return s;
                }
            }
        }
        return korjattu;
    }
}
