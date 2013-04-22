package ViiteKirjaus.controller;



import ViiteKirjaus.domain.Attribuutti;
import ViiteKirjaus.domain.Viite;
import ViiteKirjaus.services.BibtexKaannin;
import ViiteKirjaus.services.data_access.*;
import ViiteKirjaus.utils.SeedTestData;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class HelloController {


    @RequestMapping("*")
    public ModelAndView index() {
        ModelAndView result = new ModelAndView("etusivu");

        result.addObject("viitteet",Tietokanta.levylla().listaa().kaikki_viitteet());
        return result;
    }
    
    
    @RequestMapping("lista")
    public ModelAndView lista() {
        
        ModelAndView result = new ModelAndView("lista");

        result.addObject("viitteet",Tietokanta.levylla().listaa().kaikki_viitteet());
        return result;
    }
    
//    @RequestMapping("lista")
//    public String lista() {
//        return "lista";
//        
//    }
    
    
    
    @RequestMapping("listaaKaikki")
    public ModelAndView listaaKaikki() {
        ModelAndView result = new ModelAndView("listaaKaikki");
        BibtexKaannin kaannin = new BibtexKaannin();
        
        String kaikki = "";
        List<Viite> viitteet = Tietokanta.levylla().listaa().kaikki_viitteet();
        for (int i = 0; i < viitteet.size(); i++){
            kaikki += kaannin.kaanna(viitteet.get(i)) + "\n\n";
        }
                
        result.addObject("all", kaikki);
        return result;
    }    
    
    @RequestMapping("viite/{id}")
    public ModelAndView viiteNayta(@PathVariable("id") int id) {
        Viite v = Tietokanta.levylla().etsi().viite_jonka_id(id);
        if (v == null) {
            // passataan viewille "dummy" viite olio
            v = new Viite("empty", new Attribuutti[]{});
        }
        
        ModelAndView result = new ModelAndView("viite");
        result.addObject("viite", v);
        
        BibtexKaannin kaannin = new BibtexKaannin();
        String parsittu = kaannin.kaanna(v);
        result.addObject("parsed", parsittu);
        
        return result;
    }
    
    @RequestMapping("viite/{id}/poista")
    public String viitePoista(@PathVariable("id") int id) {
        Tietokanta.levylla().poista().viite(id);
        
        return "redirect:/home";
        
    }
    
    @RequestMapping("kirja/lisaa")
    public String kirjaLisaa() {
        return "kirja";
    }
    
    @RequestMapping(value = "kirja/lisaa", method = RequestMethod.POST)
    public ModelAndView kirjaLisaaKasittele(HttpServletRequest request, HttpServletResponse response) {
        String ID = request.getParameter("ID");
        String author = request.getParameter("author");
        String title = request.getParameter("title");
        String year = request.getParameter("year");
        String publisher = request.getParameter("publisher");
        String address = request.getParameter("address");
        
        Viite kirja = new Viite("book",
                new Attribuutti[]{
                    new Attribuutti("id", ID),
                    new Attribuutti("author", author),
                    new Attribuutti("title", title),
                    new Attribuutti("year", year),
                    new Attribuutti("publisher", publisher),
                    new Attribuutti("address", address)
                });

        
        Tietokanta.levylla().tallenna().viite(kirja);
        
        
        BibtexKaannin kaannin = new BibtexKaannin();
        String parsittu = kaannin.kaanna(kirja);
        //System.out.println(parsittu);
   
        
        ModelAndView result = new ModelAndView("kirja");
        result.addObject("viite", kirja);
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
        String volume = request.getParameter("volume");
        String number = request.getParameter("number");
        String pages = request.getParameter("pages");
        String address = request.getParameter("address");
        
        Viite artikkeli = new Viite("article",
                new Attribuutti[]{
                    new Attribuutti("id", ID),
                    new Attribuutti("author", author),
                    new Attribuutti("title", title),
                    new Attribuutti("journal", journal),
                    new Attribuutti("year", year),
                    new Attribuutti("publisher", publisher),
                    new Attribuutti("volume", volume),
                    new Attribuutti("number", number),
                    new Attribuutti("pages", pages),
                    new Attribuutti("address", address)
                });

        Tietokanta.levylla().tallenna().viite(artikkeli);
        
        
        BibtexKaannin kaannin = new BibtexKaannin();
        String parsittu = kaannin.kaanna(artikkeli);
        //System.out.println(parsittu);
   
        
        ModelAndView result = new ModelAndView("artikkeli");
        result.addObject("viite", artikkeli);
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
        String pages = request.getParameter("pages");
        String address = request.getParameter("address");
        
        Viite konferenssi = new Viite("inproceeding",
                new Attribuutti[]{
                    new Attribuutti("id", ID),
                    new Attribuutti("author", author),
                    new Attribuutti("title", title),
                    new Attribuutti("booktitle", journal),
                    new Attribuutti("year", year),
                    new Attribuutti("pages", pages),
                    new Attribuutti("address", address)
                });

        //dao.add(konferenssi);
        Tietokanta.levylla().tallenna().viite(konferenssi);
        
        BibtexKaannin kaannin = new BibtexKaannin();
        String parsittu = kaannin.kaanna(konferenssi);
        //System.out.println(parsittu);
   
        
        ModelAndView result = new ModelAndView("konferenssi");
        result.addObject("viite", konferenssi);
        result.addObject("parsed", parsittu);
        return result;
        
    }
    
    @RequestMapping("haku")
    public String viiteHaku() {
        return "haku";
    }
    
    @RequestMapping(value = "haku", method = RequestMethod.POST)
    public ModelAndView viiteHakuKasittele(HttpServletRequest request, HttpServletResponse response) {
        String searchByAuthor = request.getParameter("search-author");
        
        List<Viite> viitteet = Tietokanta.levylla().listaa().viitteet_joissa_kirjailijana(searchByAuthor);
        
        ModelAndView result = new ModelAndView("haku");
        result.addObject("viitteet", viitteet);
        return result;
    }
    
    @RequestMapping("debug/dbs")
    public String nuket() {
        SeedTestData std = new SeedTestData();
        std.Nuket(new InMemoryViiteDao());
        return "redirect:/home";
    }
    
    
}