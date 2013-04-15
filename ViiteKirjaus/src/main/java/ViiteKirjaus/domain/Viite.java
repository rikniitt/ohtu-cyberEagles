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
        
        generoiId();
    }
    
    public String getTyyppi(){
        return tyyppi;
    }
    
    public Attribuutti[] getAttribuutit(){
        return attribuutit;
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
        String id = author.substring(0, 1);
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
                id += author.substring(i, i+1);
                kirjainLisatty = true;
            }
        }
        
        id += year.substring(2, 4);

        for (Attribuutti attribuutti : attribuutit) {
            if (attribuutti.getNimi().equals("id")){
                attribuutti.setArvo(id);
                return;
            }
        }
        
    }
}
