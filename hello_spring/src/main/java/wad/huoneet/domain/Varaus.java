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

@Entity
public class Varaus implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    private int huoneId;
    private int henkiloId;
    private int varausId;

    public Varaus() {
    }

    public int getHuoneId() {
        return huoneId;
    }

    public void setHuoneId(int huoneId) {
        this.huoneId = huoneId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVarausId() {
        return varausId;
    }

    public void setVarausId(int varausId) {
        this.varausId = varausId;
    }

    public int getHenkiloId() {
        return henkiloId;
    }

    public void setHenkiloId(int henkiloId) {
        this.henkiloId = henkiloId;
    }
}
