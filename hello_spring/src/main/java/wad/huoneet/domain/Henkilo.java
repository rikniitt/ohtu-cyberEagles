/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.huoneet.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Henkilo implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    
    @NotNull(message="Nimi ei saa olla tyhjä")
    @Size(min=4, max=12, message="Nimimerkissä saa olla 4-12 merkkiä")
    @Pattern(regexp="[\\w\\s\\-]*", message="Nimi saa sisältää vain kirjaimia, numeroita, väliviivoja ja välilyöntejä")
    private String nimi;
    
    @Pattern(regexp="[\\w\\s\\.\\,]*", message="Osoite saa sisältää vain kirjaimia, numeroita, pisteitä, pilkkuja ja välilyöntejä")
    private String osoite;
    
    @Size(min=8, max=12, message="Puhelinnumero saa olla 8-12 merkkiä")
    @Pattern(regexp="[0-9]*", message="Puhelinnumero saa sisältää numeroita")
    private String puhNumero;

    public Henkilo() {
    }

    public int getId() {
        return id;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public String getOsoite() {
        return osoite;
    }

    public void setOsoite(String osoite) {
        this.osoite = osoite;
    }

    public String getPuhNumero() {
        return puhNumero;
    }

    public void setPuhNumero(String puhNumero) {
        this.puhNumero = puhNumero;
    }
    
    
    
}
