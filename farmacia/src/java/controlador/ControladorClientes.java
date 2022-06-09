/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Clientes;
import modeloDAD.ClientesDAO;


public class ControladorClientes extends HttpServlet {
    
    String listarClientes = "vistas/listarClientes.jsp";
    String addClientes = "vistas/addClientes.jsp";
    String editClientes = "vistas/editClientes.jsp";
    Clientes cli = new Clientes();
    ClientesDAO dad = new ClientesDAO();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorClientes</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorClientes at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso = "";
        String action = request.getParameter("accion");
        if(action.equalsIgnoreCase("listarClientes")){
        
            acceso=listarClientes;
        }
        else if(action.equalsIgnoreCase("addCliente")){
            acceso=addClientes;
        }
        else if(action.equalsIgnoreCase("saveCliente")){
            String id = request.getParameter("txtid");
            String nom = request.getParameter("txtNombre");
            String Ape = request.getParameter("txtApellido");
            String tele = request.getParameter("txtTelefono");
            String direc = request.getParameter("txtDireccion");
            String correo = request.getParameter("txtCorreo");
            
            cli.setId(Integer.parseInt(id));
            cli.setNombre(nom);
            cli.setApellido(Ape);
            cli.setTelefono(Integer.parseInt(tele));
            cli.setDireccion(direc);
            cli.setCorreo(correo);
            dad.addClientes(cli);
            acceso =listarClientes;
        }
        else if(action.equalsIgnoreCase("edit")){
            request.setAttribute("idCli", request.getParameter("id"));
            acceso = editClientes;
        }
        else if(action.equalsIgnoreCase("updateCliente")){
            int id = Integer.parseInt(request.getParameter("txtid"));
            String nom = request.getParameter("txtNombre");
            String Ape = request.getParameter("txtApellido");
            String tele = request.getParameter("txtTelefono");
            String direc = request.getParameter("txtDireccion");
            String correo = request.getParameter("txtCorreo");
            cli.setId(id);
            cli.setNombre(nom);
            cli.setApellido(Ape);
            cli.setTelefono(Integer.parseInt(tele));
            cli.setDireccion(direc);
            cli.setCorreo(correo);
            dad.editClientes(cli);
            acceso=listarClientes;
        }
        else if(action.equalsIgnoreCase("delete")){
           int id = Integer.parseInt(request.getParameter("id"));
           cli.setId(id);
           dad.eliminar(id);
           acceso=listarClientes;
        }
        RequestDispatcher vista= request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
