package wad.huoneet.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import wad.huoneet.domain.Henkilo;
import wad.huoneet.domain.Huone;
import wad.huoneet.domain.Varaus;
import wad.huoneet.service.HenkiloPalvelu;
import wad.huoneet.service.HuonePalvelu;
import wad.huoneet.service.VarausPalvelu;


@Controller
public class HuoneetController {

    @Autowired
    private HuonePalvelu huonePalvelu;
    
    @Autowired
    private HenkiloPalvelu henkiloPalvelu;

    @Autowired
    private VarausPalvelu varausPalvelu;
    
    
    @RequestMapping("*")
    public String defaulttiNayta() {
        return "redirect:/huone";
    }

    
    
    @RequestMapping("huone")
    public String listaaHuoneet(Model model) {
        model.addAttribute("huoneet", huonePalvelu.listaa());
        return "huone";
    }

    @RequestMapping(value = "huone/lisaa", method = RequestMethod.POST)
    public String lisaaHuone(@ModelAttribute Huone huone) {
        huonePalvelu.lisaa(huone);
        return "redirect:/huone";
    }

    @RequestMapping(value = "huone/poista/{huoneId}")
    public String poistaHuone(@PathVariable Integer huoneId) {
        huonePalvelu.poista(huoneId);
        return "redirect:/huone";
    }
    
    
    
    
    @RequestMapping("henkilo")
    public String listaaHenkilot(Model model) {
        model.addAttribute("henkilot", henkiloPalvelu.listaa());
        return "henkilo";
    }

    @RequestMapping(value = "henkilo/lisaa", method = RequestMethod.POST)
    public String lisaaHenkilo(@ModelAttribute Henkilo henkilo) {
        henkiloPalvelu.lisaa(henkilo);
        return "redirect:/henkilo";
    }

    @RequestMapping(value = "henkilo/poista/{henkiloId}")
    public String poistaHenkilo(@PathVariable Integer henkiloId) {
        henkiloPalvelu.poista(henkiloId);
        return "redirect:/henkilo";
    }
    
    
   
    
    @RequestMapping("varaus")
    public String listaaVaraukset(Model model) {
        model.addAttribute("huoneet", huonePalvelu.listaa());
        model.addAttribute("henkilot", henkiloPalvelu.listaa());
        model.addAttribute("varaukset", varausPalvelu.listaa());
        return "varaus";
    }

    @RequestMapping(value = "varaus/lisaa", method = RequestMethod.POST)
    public String lisaaVaraus(@ModelAttribute Varaus varaus) {
        varausPalvelu.lisaa(varaus);
        return "redirect:/varaus";
    }

    @RequestMapping(value = "varaus/poista/{varausId}")
    public String poistaVaraus(@PathVariable Integer varausId) {
        varausPalvelu.poista(varausId);
        return "redirect:/varaus";
    }
    
    
    
        
    
    
    
    @RequestMapping(value = "validi_henkilo")
    public String lisaaValidiHenkilo(@ModelAttribute Henkilo henkilo) {
        return "validi_henkilo"; // viewi
    }
    // Validointi esimerkki
    @RequestMapping(value = "validi_henkilo", method = RequestMethod.POST)
    public String lisaaValidiHenkilo(@Valid @ModelAttribute Henkilo henkilo, BindingResult result) {
        if (result.hasErrors()) {
            return "validi_henkilo"; // viewi
        }
        henkiloPalvelu.lisaa(henkilo);
        return "redirect:/henkilo";
    }
    

}
