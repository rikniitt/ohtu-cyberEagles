/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ViiteKirjaus.utils;

import ViiteKirjaus.domain.Attribuutti;
import ViiteKirjaus.domain.Viite;
import ViiteKirjaus.services.data_access.*;
import ViiteKirjaus.services.data_access.ViiteDao;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author rikniitt
 */
public class SeedTestData {


    public void Nuket(ViiteDao dao) {
        Viite k;
        
        Attribuutti[] a;

        a = new Attribuutti[]{
                    new Attribuutti("publisher", "IEEE Computer Society"),
                    new Attribuutti("editor", "Abram, Aman and More, James W. and Bourgue Pierre and Dupuis Robert"),
                    new Attribuutti("year", "2004"),
                    new Attribuutti("title", "Guide to the Software Engineering Body of Knownledge")
                };
        
        k = new Viite("book", a);
        
        Tietokanta.levylla().tallenna().viite(k);
        dao.add(k);
        
        a = new Attribuutti[]{
                    new Attribuutti("author", "Beck, Kent and Andres, Cynthia"),
                    new Attribuutti("title", "Extreme Programming Explained: Embrace Change (2nd Edition)"),
                    new Attribuutti("year", "2004"),
                    new Attribuutti("publisher", "Addison-Wesley Professional")
                };
        
        k = new Viite("book", a);
        
        Tietokanta.levylla().tallenna().viite(k);
        dao.add(k);
        
        a = new Attribuutti[]{
                    new Attribuutti("author", "Royce, Walker"),
                    new Attribuutti("title", "Managing the Development of Large Software Systems"),
                    new Attribuutti("BOOKTITLE", "Proceedings of IEEE WESCON 26"),
                    new Attribuutti("ORGANIZATION", "TeX Users Group"),
                    new Attribuutti("ORGANIZATION", "TeX Users Group"),
                    new Attribuutti("MONTH", "August"),
                    new Attribuutti("YEAR", "1970")
                };
        
        k = new Viite("INPROCEEDINGS", a);
        
        Tietokanta.levylla().tallenna().viite(k);
        dao.add(k);
        
        a = new Attribuutti[]{
                    new Attribuutti("author", "Begel, Andrew and Simon, Beth"),
                    new Attribuutti("title", "Struggles of new college graduates in their first software development job"),
                    new Attribuutti("booktitle", "Proceedings of the SIGCSE '08"),
                    new Attribuutti("year", "2008"),
                    new Attribuutti("publisher", "ACM")
                };
        
        k = new Viite("inproceedings", a);
        
        Tietokanta.levylla().tallenna().viite(k);
        dao.add(k);
        
        a = new Attribuutti[]{
                    new Attribuutti("author", "Fox, Armando and Patterson, David"),
                    new Attribuutti("title", "Crossing the software education chasm"),
                    new Attribuutti("journal", "Communications of ACM"),
                    new Attribuutti("volume", "55"),
                    new Attribuutti("number", "5"),
                    new Attribuutti("month", "may"),
                    new Attribuutti("year", "2012"),
                    new Attribuutti("pages", "44--49"),
                    new Attribuutti("publisher", "ACM"),
                    new Attribuutti("address", "New York, NY, USA")
                };
        
        k = new Viite("article", a);
        
        Tietokanta.levylla().tallenna().viite(k);
        dao.add(k);
        
        a = new Attribuutti[]{
                    new Attribuutti("author", "Martin, Robert C"),
                    new Attribuutti("title", "Clean Code: A Handbook of Agile Software Craftsmanship"),
                    new Attribuutti("year", "2008"),
                    new Attribuutti("publisher", "Prentice Hall"),
                };
        
        k = new Viite("book", a);
        
        Tietokanta.levylla().tallenna().viite(k);
        dao.add(k);
        
        a = new Attribuutti[]{
                    new Attribuutti("author", "Ken Schwaber and Mike Beedle"),
                    new Attribuutti("publisher", "Prentice Hall"),
                    new Attribuutti("title", "Agile Software Development with SCRUM"),
                    new Attribuutti("year", "2002")
                };
        
        k = new Viite("book", a);
        
        Tietokanta.levylla().tallenna().viite(k);
        dao.add(k);


    }
}
