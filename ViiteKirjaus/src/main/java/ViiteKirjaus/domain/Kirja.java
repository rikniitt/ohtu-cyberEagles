/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ViiteKirjaus.domain;

/**
 *
 * @author olzraiti
 */
public class Kirja {

//    public Id id;
//    public Kirjailija kirjailija;
//    public Titteli titteli;
//    public Vuosi vuosi;
//    public Julkaisija julkaisija;
//
//    public Kirja(Id id, Kirjailija kirjailija, Titteli titteli, Vuosi vuosi, Julkaisija julkaisija) {
//        this.id = id;
//        this.kirjailija = kirjailija;
//        this.titteli = titteli;
//        this.vuosi = vuosi;
//        this.julkaisija = julkaisija;
//    }
    
    private Attribuutti[] attribuutit;
    
    public Kirja(Attribuutti[] attribuutit){
        this.attribuutit = attribuutit;
    }
    
    public Attribuutti[] getAttribuutit(){
        return attribuutit;
    }
}
