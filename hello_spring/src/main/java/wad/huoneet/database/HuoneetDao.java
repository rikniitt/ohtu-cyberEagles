/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.huoneet.database;

import java.util.List;
import wad.huoneet.domain.Huone;


/**
 *
 * @author makinen
 */
public interface HuoneetDao extends DAO<Huone>{
    public List<Huone> list();
}

