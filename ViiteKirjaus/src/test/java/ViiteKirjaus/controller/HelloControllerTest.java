
package ViiteKirjaus.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.*;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;



//@RunWith(SpringJUnit4ClassRunner.class)
//@TestExecutionListeners({
//        DependencyInjectionTestExecutionListener.class,
//        DirtiesContextTestExecutionListener.class,
//        TransactionalTestExecutionListener.class })
//@Transactional
//@ContextConfiguration(locations = {
//    "file:webapp/WEB-INF/front-controller-servlet.xml"
//    })
public class HelloControllerTest {

    
//    private MockHttpServletRequest request;
//    private MockHttpServletResponse response;
//
//
//
//    @Autowired
//    private RequestMappingHandlerAdapter handlerAdapter;
//
//    @Autowired
//    private RequestMappingHandlerMapping handlerMapping;
//
//    @Before
//    public void setUp() throws Exception
//    {
//        this.request = new MockHttpServletRequest();
//        request.setContentType("application/json");
//        this.response = new MockHttpServletResponse();
//    }
    
    
   @Test
   public void testHelloControllerEtusivuPalauttaaOikeanViewin() {
       HelloController c= new HelloController();
       String view = c.index();
       Assert.assertEquals("etusivu", view);
   }
   
//   @Test
//   public void testHelloControllerListaPalauttaaOikeanViewin() {
//       HelloController c= new HelloController();
//       String view = c.lista();
//       Assert.assertEquals("lista", view);
//   }
   
   @Test
   public void testHelloControllerKirjaLisaaPalauttaaOikeanViewin() {
       HelloController c= new HelloController();
       String view = c.kirjaLisaa();
       Assert.assertEquals("kirja", view);
   }
   
   @Test
   public void testHelloControllerArtikkeliLisaaPalauttaaOikeanViewin() {
       HelloController c= new HelloController();
       String view = c.artikkeliLisaa();
       Assert.assertEquals("artikkeli", view);
   }
   
   
//   @Test
//    public void testHelloControllerKirjaLisaaPostPalauttaaOikeanViewin(){
//        request.setMethod("POST");
//        request.setRequestURI("/kirja/lisaa");  
//
//        final ModelAndView mav;
//        Object handler;
//
//        try{
//
//                handler = handlerMapping.getHandler(request).getHandler();
//                mav = handlerAdapter.handle(request, response, handler);
//                Assert.assertEquals(200, response.getStatus());
//                //Assert other conditions.
//            }
//        catch (Exception e) 
//            {
//
//            } 
//    }
}

