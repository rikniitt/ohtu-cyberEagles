package ViiteKirjaus.controller;



import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
}