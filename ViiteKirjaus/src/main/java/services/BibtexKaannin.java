package services;

import ViiteKirjaus.domain.Attribuutti;
import ViiteKirjaus.domain.Viite;

/**
 *
 * @author olzraiti
 */
public class BibtexKaannin {

    /**
     * @param args the command line arguments
     */
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
        for (int i = 0; i < k.getAttribuutit().length; i++) {
            if (k.getAttribuutit()[i].getNimi().equals("id")) {
                kaannos = kaannos + k.getAttribuutit()[i] + ",\n";
                break;
            }
        }
        //muiden attribuuttien järjestyksellä ei väliä
        for (int i = 0; i < k.getAttribuutit().length; i++) {
                if (!k.getAttribuutit()[i].getNimi().equals("id")){
                    if (k.getAttribuutit()[i].getNimi().equals("pages")){                               //käännetään sivuattribuutti oikeaan muotoon
                        kaannos = kaannos + k.getAttribuutit()[i].getNimi() + " = {"
                                + kaannaSivuAttribuuttiOikein(k.getAttribuutit()[i].getArvo()) + "},\n";
                    }
                    else
                        kaannos = kaannos + k.getAttribuutit()[i].getNimi() + " = {" + k.getAttribuutit()[i] + "},\n";
                }
        }
        
        kaannos = kaannos + "}";

        

        return kaannos;
    }
    
    //12-23    12--23
    
    public String kaannaSivuAttribuuttiOikein(String s){
        String korjattu = "";
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '-'){
                if (s.charAt(i + 1) != '-'){
                    for (int j = 0; j < s.length(); j++){
                        if (j == i)
                            korjattu += "-";
                        korjattu += s.charAt(j);
                    }
                }
                else
                    return s;
            }
        }
        return korjattu;
    }
}
