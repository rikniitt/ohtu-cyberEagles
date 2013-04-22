package ViiteKirjaus.services;

import ViiteKirjaus.domain.Attribuutti;
import ViiteKirjaus.domain.Viite;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author olzraiti
 */
public class BibtexKaannin {
    
    private String sisennys = "    ";
    
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
        String kaannos = b.kaanna(k);
        System.out.println(kaannos);
        
        
        Viite v = new Viite("book", new Attribuutti[]{
                    new Attribuutti("id", "Ö12"),
                    new Attribuutti("author", "Öhman J."),
                    new Attribuutti("title", "Jääkausi"),
                    new Attribuutti("year", "2012"),
                    new Attribuutti("publisher", "Oy Åland Ab"),
                    new Attribuutti("pages", "121-207")
        });
        kaannos = b.kaannaAakkosetLatexMuotoon(v);
        System.out.println(kaannos);
    }

    public String kaanna(Viite k) {
        String kaannos = "@" + k.getTyyppi() + "{";

        //IDn täytyy olla ensimmäisenä
        ArrayList<Attribuutti> kaannettavatAttribuutit = new ArrayList<Attribuutti>();
        kaannettavatAttribuutit.addAll( k.getAttribuutit() );

        for (int i = 0; i < kaannettavatAttribuutit.size(); i++) {
            Attribuutti a = kaannettavatAttribuutit.get(i);
            if (a.getNimi().equals("id")) {
                kaannos += a.toString() + ",\n";
                kaannettavatAttribuutit.remove(a);
                break;
            }
        }

        //muiden attribuuttien järjestyksellä ei väliä
        for (int i = 0; i < kaannettavatAttribuutit.size(); i++) {
            kaannos += sisennys;
            Attribuutti a = kaannettavatAttribuutit.get(i);
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
    
    public String kaannaAakkosetLatexMuotoon(Viite k)  {
        String kaannos = kaanna(k);
        
        for (int i = 0; i < kaannos.length(); i++)  {
            if (kaannos.charAt(i) == 'å')   {
                kaannos = kaannos.substring(0, i) + "\\{aa}" + kaannos.substring(i+1, kaannos.length());
            }
            if (kaannos.charAt(i) == 'ä')   {
                kaannos = kaannos.substring(0, i) + "\\\"{a}" + kaannos.substring(i+1, kaannos.length());
            }
            if (kaannos.charAt(i) == 'ö')   {
                kaannos = kaannos.substring(0, i) + "\\\"{o}" + kaannos.substring(i+1, kaannos.length());
            }
            if (kaannos.charAt(i) == 'Å')   {
                kaannos = kaannos.substring(0, i) + "\\{AA}" + kaannos.substring(i+1, kaannos.length());
            }
            if (kaannos.charAt(i) == 'Ä')   {
                kaannos = kaannos.substring(0, i) + "\\\"{A}" + kaannos.substring(i+1, kaannos.length());
            }
            if (kaannos.charAt(i) == 'Ö')   {
                kaannos = kaannos.substring(0, i) + "\\\"{O}" + kaannos.substring(i+1, kaannos.length());
            } 
        }
        
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
