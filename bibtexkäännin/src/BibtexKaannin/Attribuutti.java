/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BibtexKaannin;

/**
 *
 * @author olzraiti
 */
public class Attribuutti {

    private String nimi;
    private String arvo;

    public Attribuutti (String nimi, String arvo) {
        this.nimi = nimi;
        this.arvo = arvo;
    }
    
    @Override
    public String toString(){
        return arvo;
    }
    
    public String getNimi(){
        return nimi;
    }
    
    public String getArvo(){
        return arvo;
    }
}
