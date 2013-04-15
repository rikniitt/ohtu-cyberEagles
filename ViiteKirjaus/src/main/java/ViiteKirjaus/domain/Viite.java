/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ViiteKirjaus.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author olzraiti
 */
@ Entity
public class Viite {
    
    @Id
    private Integer id;
    
    private String tyyppi;
    
    
    private List<Attribuutti> attribuutit;    

    public Viite() {
    }
    
    public Viite(String tyyppi, Attribuutti[] attribuutit){
        
        this.tyyppi = tyyppi;
        
        ArrayList<Attribuutti> karsinta = new ArrayList<Attribuutti>();
        
        //karsitaan tyhjät attribuutit pois
        for (Attribuutti a : attribuutit){
            if (!a.getArvo().trim().equals("")){
                karsinta.add(a);
            }
        }
        this.attribuutit = karsinta;
    }
    
    public String getTyyppi(){
        return tyyppi;
    }
    
//    public Attribuutti[] getAttribuutit(){
//        return (Attribuutti[])attribuutit.toArray();
//    }
    
    public String getAttribuutti(String nimi){
        for (Attribuutti a : attribuutit) {
            if (a.getNimi().equals(nimi)) {
                return a.getArvo();
            }
        }
        return "";
    }
    
    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Attribuutti> getAttribuutit() {
        return attribuutit;
    }

    public void setAttribuutit(List<Attribuutti> attribuutit) {
        this.attribuutit = attribuutit;
    }
    
    
    
    
    
    
    
    
}
