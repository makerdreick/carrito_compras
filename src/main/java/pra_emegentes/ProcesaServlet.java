package pra_emegentes;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ProcesaServlet", urlPatterns = {"/ProcesaServlet"})
public class ProcesaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("en el Servlet");
        /// obtenermos    acceso al objetos
        HttpSession   ses = request.getSession();
        // se elimina la sesion
        ses.invalidate();
        //trasnferere el control a index.jsp
        response.sendRedirect("index.jsp");
    }
    @Override
    protected  void doPost (HttpServletRequest request, HttpServletResponse reponse )
            throws  ServletException,IOException{
        System.out.println("En el  metodo poss del Servlet");
    // recuperamos  el producto enviado desde formulario. 
       String producto =request.getParameter("producto");
    // se obtiene el acceso  de la  seccion
       HttpSession ses= request.getSession();
       //se obtiene  la  lista de esta como atributo de session
        ArrayList<String> lista = (ArrayList<String>)ses.getAttribute("lista");
        // a la coleccion de adiciona  el elmeneto producto
        lista.add(producto);
        // Se redirecciona a index.jsp
        reponse.sendRedirect("index.jsp");
    }
}