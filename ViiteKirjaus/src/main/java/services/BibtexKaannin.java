package services;

import ViiteKirjaus.domain.Attribuutti;
import ViiteKirjaus.domain.Kirja;

/**
 *
 * @author olzraiti
 */
public class BibtexKaannin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Kirja k = new Kirja(
                new Attribuutti[]{
                    new Attribuutti("id", "Pek123"),
                    new Attribuutti("author", "Pekka Joki"),
                    new Attribuutti("title", "joku raamattu"),
                    new Attribuutti("year", "1920"),
                    new Attribuutti("publisher", "WSOY"),
                    new Attribuutti("asd", " ")
                });

        BibtexKaannin b = new BibtexKaannin();
        String kkk = b.kaanna(k);
        System.out.println(kkk);
    }

    public String kaanna(Kirja k) {
        String kaannos = "@book{";

        //IDn täytyy olla ensimmäisenä
        for (int i = 0; i < k.getAttribuutit().length; i++) {
            if (k.getAttribuutit()[i].getNimi().equals("id")) {
                kaannos = kaannos + k.getAttribuutit()[i] + ",\n";
                break;
            }
        }
        //muiden attribuuttien järjestyksellä ei väliä
        for (int i = 0; i < k.getAttribuutit().length; i++) {
                if (!k.getAttribuutit()[i].getNimi().equals("id"))
                    kaannos = kaannos + k.getAttribuutit()[i].getNimi() + " = " + k.getAttribuutit()[i] + ",\n";
        }
        
        kaannos = kaannos + "}";

        

        return kaannos;
    }
}
