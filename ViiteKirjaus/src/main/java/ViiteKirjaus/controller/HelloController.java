package ViiteKirjaus.controller;



import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping("index")
    public void index(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.getWriter().write("Hellosdfsdsdf sdf sdf sdf  World!");
        } catch (IOException ex) {
            System.out.println("Ei onnistunut!");
        }
    }
}