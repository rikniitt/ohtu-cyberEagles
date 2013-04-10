package ViiteKirjaus.controller;



import ViiteKirjaus.domain.Attribuutti;
import services.BibtexKaannin;
import ViiteKirjaus.domain.Viite;
import java.io.IOException;
import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView kirjaLisaaKasittele(HttpServletRequest request, HttpServletResponse response) {
        String ID = request.getParameter("ID");
        String kirjailija = request.getParameter("kirjailija");
        String titteli = request.getParameter("titteli");
        String vuosi = request.getParameter("vuosi");
        String julkaisija = request.getParameter("julkaisija");
        
        Viite kirja = new Viite("book",
                new Attribuutti[]{
                    new Attribuutti("id", ID),
                    new Attribuutti("author", kirjailija),
                    new Attribuutti("title", titteli),
                    new Attribuutti("year", vuosi),
                    new Attribuutti("publisher", julkaisija)
                });

        BibtexKaannin kaannin = new BibtexKaannin();
        String parsittu = kaannin.kaanna(kirja);
        System.out.println(parsittu);
   
        
        ModelAndView result = new ModelAndView("kirja");
        result.addObject("parsed", parsittu);
        return result;
        
    }
    
    
    
    
}