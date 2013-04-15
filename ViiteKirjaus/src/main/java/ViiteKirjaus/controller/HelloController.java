package ViiteKirjaus.controller;



import ViiteKirjaus.domain.Attribuutti;
import ViiteKirjaus.domain.Viite;
import ViiteKirjaus.services.BibtexKaannin;
import ViiteKirjaus.services.data_access.ViiteDao;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @Autowired ViiteDao dao;

    @RequestMapping("*")
    public String index() {
        return "etusivu";
    }
    
    
    @RequestMapping("lista")
    public ModelAndView lista() {
        
        ModelAndView result = new ModelAndView("lista");

        result.addObject("viitteet",dao.listAll());
        return result;
        
    }
    
//    @RequestMapping("lista")
//    public String lista() {
//        return "lista";
//        
//    }
    
    
    
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

        
        dao.add(kirja);
        
        
        BibtexKaannin kaannin = new BibtexKaannin();
        String parsittu = kaannin.kaanna(kirja);
        //System.out.println(parsittu);
   
        
        ModelAndView result = new ModelAndView("kirja");
        result.addObject("parsed", parsittu);
        return result;
        
    }
    
    
    
    
    
    
    @RequestMapping("artikkeli/lisaa")
    public String artikkeliLisaa() {
        return "artikkeli";
    }
    
    @RequestMapping(value = "artikkeli/lisaa", method = RequestMethod.POST)
    public ModelAndView artikkeliLisaaKasittele(HttpServletRequest request, HttpServletResponse response) {
        String ID = request.getParameter("ID");
        String author = request.getParameter("author");
        String title = request.getParameter("title");
        String journal = request.getParameter("journal");
        String year = request.getParameter("year");
        String publisher = request.getParameter("publisher");
        
        Viite artikkeli = new Viite("article",
                new Attribuutti[]{
                    new Attribuutti("id", ID),
                    new Attribuutti("author", author),
                    new Attribuutti("title", title),
                    new Attribuutti("journal", journal),
                    new Attribuutti("year", year),
                    new Attribuutti("publisher", publisher)
                });

        
        dao.add(artikkeli);
        
        
        BibtexKaannin kaannin = new BibtexKaannin();
        String parsittu = kaannin.kaanna(artikkeli);
        //System.out.println(parsittu);
   
        
        ModelAndView result = new ModelAndView("artikkeli");
        result.addObject("parsed", parsittu);
        return result;
        
    }
    
    
    @RequestMapping("konferenssi/lisaa")
    public String konferenssiLisaa() {
        return "konferenssi";
    }
    
    @RequestMapping(value = "konferenssi/lisaa", method = RequestMethod.POST)
    public ModelAndView konferenssiLisaaKasittele(HttpServletRequest request, HttpServletResponse response) {
        String ID = request.getParameter("ID");
        String author = request.getParameter("author");
        String title = request.getParameter("title");
        String journal = request.getParameter("booktitle");
        String year = request.getParameter("year");
        
        Viite konferenssi = new Viite("inproceeding",
                new Attribuutti[]{
                    new Attribuutti("id", ID),
                    new Attribuutti("author", author),
                    new Attribuutti("title", title),
                    new Attribuutti("booktitle", journal),
                    new Attribuutti("year", year),
                });

        
        dao.add(konferenssi);
        
        
        BibtexKaannin kaannin = new BibtexKaannin();
        String parsittu = kaannin.kaanna(konferenssi);
        //System.out.println(parsittu);
   
        
        ModelAndView result = new ModelAndView("konferenssi");
        result.addObject("parsed", parsittu);
        return result;
        
    }
    
    
}