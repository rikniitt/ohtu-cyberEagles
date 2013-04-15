/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ViiteKirjaus.domain;

import java.util.ArrayList;

/**
 *
 * @author olzraiti
 */
public class Viite {
    
    private String tyyppi;
    private Attribuutti[] attribuutit;
    
    public Viite(String tyyppi, Attribuutti[] attribuutit){
        
        this.tyyppi = tyyppi;
        
        ArrayList<Attribuutti> karsinta = new ArrayList<Attribuutti>();
        
        //karsitaan tyhjät attribuutit pois
        for (Attribuutti a : attribuutit){
            if (!a.getArvo().trim().equals("")){
                karsinta.add(a);
            }
        }
        this.attribuutit =  karsinta.toArray(new Attribuutti[karsinta.size()]);
    }
    
    public String getTyyppi(){
        return tyyppi;
    }
    
    public Attribuutti[] getAttribuutit(){
        return attribuutit;
    }
    
    public String getAttribuutti(String nimi){
        for (Attribuutti a : attribuutit)
            if (a.getNimi().equals(nimi))
                return a.getArvo();
        return "";
    }
    
    public int getId() { return 666; }
    
    
    
}
