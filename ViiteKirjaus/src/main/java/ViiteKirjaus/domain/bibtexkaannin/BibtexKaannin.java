package ViiteKirjaus.domain.bibtexkaannin;

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
                    new Attribuutti("publisher", "WSOY")
                });

        BibtexKaannin b = new BibtexKaannin();
        String kkk = b.kaanna(k);
        System.out.println(kkk);
    }

//    @book{Martin09,
//author = {Martin, Robert},
//title = {Clean Code: A Handbook of Agile Software Craftsmanship},
//year = {2008},
//publisher = {Prentice Hall},
//}
    public String kaanna(Kirja k) {
        String kaannos = "@book{";

        //IDn täytyy olla ensimmäisenä
        for (int i = 0; i < k.attribuutit.length; i++) {
            if (k.attribuutit[i].getNimi().equals("id")) {
                kaannos = kaannos + k.attribuutit[i] + ",\n";
            }
        
        //muiden attribuuttien järjestyksellä ei väliä
        for (i = 0; i < k.attribuutit.length; i++) {
                kaannos = kaannos + k.attribuutit[i].getNimi() + " = " + k.attribuutit[i] + ",\n";
        }
        
        kaannos = kaannos + "}";

        

        }
        return kaannos;
    }
}
