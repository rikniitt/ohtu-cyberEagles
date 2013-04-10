package ViiteKirjaus.controller;



import ViiteKirjaus.domain.Attribuutti;
import ViiteKirjaus.domain.Viite;
import ViiteKirjaus.services.BibtexKaannin;
import ViiteKirjaus.services.data_access.ViiteDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
//
//    @Autowired ViiteDao dao;

    @RequestMapping("*")
    public String index() {
        return "etusivu";
    }
    
    
//    @RequestMapping("lista")
//    public ModelAndView lista() {
//        
//        ModelAndView result = new ModelAndView("lista");
//        result.addObject("viitteet", dao.listAll());
//        return result;
//        
//    }
    
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

        
        //dao.add(kirja);
        
        
        BibtexKaannin kaannin = new BibtexKaannin();
        String parsittu = kaannin.kaanna(kirja);
        System.out.println(parsittu);
   
        
        ModelAndView result = new ModelAndView("kirja");
        result.addObject("parsed", parsittu);
        return result;
        
    }
    
    
    
    
}