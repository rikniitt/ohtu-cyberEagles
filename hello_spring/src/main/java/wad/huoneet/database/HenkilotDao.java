/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.huoneet.database;

import java.util.List;
import wad.huoneet.domain.Henkilo;


/**
 *
 * @author makinen
 */
public interface HenkilotDao extends DAO<Henkilo>{
    public List<Henkilo> list();
}

