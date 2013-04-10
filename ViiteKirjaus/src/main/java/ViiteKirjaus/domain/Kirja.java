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
public class Kirja {
    
    private Attribuutti[] attribuutit;
    
    public Kirja(Attribuutti[] attribuutit){
        
        ArrayList<Attribuutti> karsinta = new ArrayList<Attribuutti>();
        
        //karsitaan tyhjät attribuutit pois
        for (Attribuutti a : attribuutit){
            if (!a.getArvo().trim().equals("")){
                karsinta.add(a);
            }
        }
        System.out.println(karsinta.size());
        this.attribuutit =  karsinta.toArray(new Attribuutti[karsinta.size()]);
        System.out.println(this.attribuutit.length);
    }
    
    public Attribuutti[] getAttribuutit(){
        return attribuutit;
    }
}
