package com.emergentes;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "Contadores", urlPatterns = {"/Contadores"})
public class Contadores extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
      int contador = 0;
      //obtener el arreglo de cookie del cliente
      Cookie[] cukis= request.getCookies();
      
      if(cukis!=null){
          for(Cookie c : cukis){
              if(c.getName().equals("visitas"))
              {
                  contador = Integer.parseInt(c.getValue());
              }
          }
      }
      contador++;
      //antes de la asignacion se  convierte a cadena el valor
      Cookie c= new Cookie("visitas",Integer.toString(contador));
      
      c.setMaxAge(3600);
      response.addCookie(c);
      //generar contenido a partir del seervlet
      response.setContentType("text/html");
      
      PrintWriter out =response.getWriter();
      out.print("Vistante Nro :" + contador);
     }
    
       @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
