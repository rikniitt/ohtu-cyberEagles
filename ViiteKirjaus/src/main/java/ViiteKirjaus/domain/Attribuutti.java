/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ViiteKirjaus.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author olzraiti
 */
@Entity
public class Attribuutti {

    private String nimi;
    
    private String arvo;
    
    @Id
    private Integer id;
    
    @ManyToOne
    private Viite viite;

    public Attribuutti() {
    }
    
    

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public void setArvo(String arvo) {
        this.arvo = arvo;
    }
    
}
