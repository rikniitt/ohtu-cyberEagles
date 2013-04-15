/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ViiteKirjaus.services.data_access;

import com.avaje.ebean.EbeanServer;

/**
 *
 * @author markusno
 */
public interface DB_config {

    EbeanServer getServer();
    
}
