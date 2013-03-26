package BibtexKaannin;

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
                    new Id("Pek123"),
                    new Kirjailija("Pekka Joki"),
                    new Titteli("joku raamattu"),
                    new Vuosi("1920"),
                    new Julkaisija("WSOY")
                });

        kaanna(k);
    }

//    @book{Martin09,
//author = {Martin, Robert},
//title = {Clean Code: A Handbook of Agile Software Craftsmanship},
//year = {2008},
//publisher = {Prentice Hall},
//}
    public static void kaanna(Kirja k) {
        String kaannos = "@book{";

        //IDn täytyy olla ensimmäisenä
        for (int i = 0; i < k.attribuutit.length; i++) {
            if (k.attribuutit[i].getClass().getName().equals("BibtexKaannin.Id")) {
                kaannos = kaannos + k.attribuutit[i] + ",\n";
            }
        
        //muiden attribuuttien järjestyksellä ei väliä
        for (i = 0; i < k.attribuutit.length; i++) {
            if (k.attribuutit[i].getClass().getName().equals("BibtexKaannin.Kirjailija")) {
                kaannos = kaannos + "author = " + k.attribuutit[i] + ",\n";
            } else if (k.attribuutit[i].getClass().getName().equals("BibtexKaannin.Titteli")) {
                kaannos = kaannos + "title = " + k.attribuutit[i] + ",\n";
            } else if (k.attribuutit[i].getClass().getName().equals("BibtexKaannin.Vuosi")) {
                kaannos = kaannos + "year = " + k.attribuutit[i] + ",\n";
            } else if (k.attribuutit[i].getClass().getName().equals("BibtexKaannin.Julkaisija")) {
                kaannos = kaannos + "publisher = " + k.attribuutit[i] + ",\n";
            }
        }
        
        kaannos = kaannos + "}";

        System.out.println(kaannos);

        }
    }
}
