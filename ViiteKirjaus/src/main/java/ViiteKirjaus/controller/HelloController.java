package ViiteKirjaus.controller;



import ViiteKirjaus.domain.bibtexkaannin.Attribuutti;
import ViiteKirjaus.domain.bibtexkaannin.BibtexKaannin;
import ViiteKirjaus.domain.bibtexkaannin.Kirja;
import java.io.IOException;
import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {

    @RequestMapping("*")
    public String index() {
        return "etusivu";
    }
    
    
    @RequestMapping("lista")
    public String lista() {
        return "lista";
    }
    
    @RequestMapping("kirja/lisaa")
    public String kirjaLisaa() {
        return "kirja";
    }
    
    @RequestMapping(value = "kirja/lisaa", method = RequestMethod.POST)
    public String kirjaLisaaKasittele(HttpServletRequest request, HttpServletResponse response) {
        String ID = request.getParameter("ID");
        String kirjailija = request.getParameter("kirjailija");
        String titteli = request.getParameter("titteli");
        String vuosi = request.getParameter("vuosi");
        String julkaisija = request.getParameter("julkaisija");
        
        Kirja k = new Kirja(
                new Attribuutti[]{
                    new Attribuutti("id", ID),
                    new Attribuutti("author", kirjailija),
                    new Attribuutti("title", titteli),
                    new Attribuutti("year", vuosi),
                    new Attribuutti("publisher", julkaisija)
                });

        BibtexKaannin b = new BibtexKaannin();
        String kkk = b.kaanna(k);
        System.out.println(kkk);
   
        return "kirja";
    }
    
    
    
    
}