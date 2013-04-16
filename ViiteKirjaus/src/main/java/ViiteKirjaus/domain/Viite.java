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

        
        generoiId();

    }
    
    public String getTyyppi(){
        return tyyppi;
    }
    


    private void generoiId() {
        String author = "AAAA";
        String year = "0000";
        for (Attribuutti attribuutti : attribuutit) {
            if (attribuutti.getNimi().equals("author")){
                author = attribuutti.getArvo();
            } 
        }
        for (Attribuutti attribuutti : attribuutit) {
            if (attribuutti.getNimi().equals("year")){
                year = attribuutti.getArvo();
            }
        }
        String ID = author.substring(0, 1);
        boolean kirjainLisatty = true;
        
        for (int i = 0; i < author.length(); i++)   {
            if (i < author.length()-5 && author.substring(i, i+5).equals(" and ")){
                kirjainLisatty = false;
                i += 4;
                continue;
            }
            if (author.substring(i, i+1).equals(" ")){
                continue;
            }
            if (!kirjainLisatty)    {
                ID += author.substring(i, i+1);
                kirjainLisatty = true;
            }
        }
        
        ID += year.substring(2, 4);

        for (Attribuutti attribuutti : attribuutit) {
            if (attribuutti.getNimi().equals("id")){
                attribuutti.setArvo(ID);
                return;
            }
        }

        attribuutit.add(0, new Attribuutti("id", ID));

    }


    
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
