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
import modelo.Empleados;
import modeloDAD.EmpleadosDAO;


public class ControladorEmpleados extends HttpServlet {

    String listarEmpleados = "vistas/listarEmpleados.jsp";
    String addEmpleados = "vistas/addEmpleados.jsp";
    String editEmpleados = "vistas/editEmpleados.jsp";
    Empleados emp = new Empleados();
    EmpleadosDAO dad = new EmpleadosDAO();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorEmpleados</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorEmpleados at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String acceso = "";
        String action = request.getParameter("accion");
        if(action.equalsIgnoreCase("listarEmpleados")){
            acceso=listarEmpleados;
        }
        else if(action.equalsIgnoreCase("addEmpleado")){
            acceso=addEmpleados;
        }
        else if(action.equalsIgnoreCase("saveEmpleado")){
            String id = request.getParameter("txtid");
            String nom = request.getParameter("txtNombre");
            String Ape = request.getParameter("txtApellido");
            String tele = request.getParameter("txtTelefono");
            String direc = request.getParameter("txtDireccion");
            String correo = request.getParameter("txtCorreo");
            
            emp.setId(Integer.parseInt(id));
            emp.setNombre(nom);
            emp.setApellido(Ape);
            emp.setTelefono(Integer.parseInt(tele));
            emp.setDireccion(direc);
            emp.setCorreo(correo);
            dad.addEmpleados(emp);
            acceso =listarEmpleados;
        }
        else if(action.equalsIgnoreCase("edit")){
            request.setAttribute("idEmp", request.getParameter("id"));
            acceso = editEmpleados;
        }
        else if(action.equalsIgnoreCase("updateEmpleado")){
            int id = Integer.parseInt(request.getParameter("txtid"));
            String nom = request.getParameter("txtNombre");
            String Ape = request.getParameter("txtApellido");
            String tele = request.getParameter("txtTelefono");
            String direc = request.getParameter("txtDireccion");
            String correo = request.getParameter("txtCorreo");
            emp.setId(id);
            emp.setNombre(nom);
            emp.setApellido(Ape);
            emp.setTelefono(Integer.parseInt(tele));
            emp.setDireccion(direc);
            emp.setCorreo(correo);
            dad.editEmpleados(emp);
            acceso=listarEmpleados;
        }
        else if(action.equalsIgnoreCase("delete")){
           int id = Integer.parseInt(request.getParameter("id"));
           emp.setId(id);
           dad.eliminar(id);
           acceso=listarEmpleados;
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
