/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BibtexKaannin;

/**
 *
 * @author olzraiti
 */
public abstract class Attribuutti {

    public String arvo;

    public Attribuutti (String arvo) {
        this.arvo = arvo;
    }
    
    @Override
    public String toString(){
        return arvo;
    }
}
