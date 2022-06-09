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
import modelo.Productos;
import modeloDAD.ProductosDAO;


public class ControladorProductos extends HttpServlet {

    String listarProductos = "vistas/listarProductos.jsp";
    String addProductos = "vistas/addProductos.jsp";
    String editProductos = "vistas/editProductos.jsp";
    Productos pro = new Productos();
    ProductosDAO dad = new ProductosDAO();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorProductos</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorProductos at " + request.getContextPath() + "</h1>");
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
        if (action.equalsIgnoreCase("listarProductos")) {
            acceso = listarProductos;
        } else if (action.equalsIgnoreCase("addProductos")) {
            acceso = addProductos;
        } else if (action.equalsIgnoreCase("saveProducto")) {
            String id = request.getParameter("txtid");
            String nom = request.getParameter("txtnombre");
            String precio = request.getParameter("txtprecio");
            String stock = request.getParameter("txtstock");
            String descripcion = request.getParameter("txtdescripcion");

            pro.setIdproductos(Integer.parseInt(id));
            pro.setNombre(nom);
            pro.setPrecio(Double.parseDouble(precio));
            pro.setStock(Integer.parseInt(stock));
            pro.setDescripcion(descripcion);
            dad.addProductos(pro);
            acceso = listarProductos;
        } else if (action.equalsIgnoreCase("edit")) {
            request.setAttribute("idProd", request.getParameter("id"));
            acceso = editProductos;
        } else if (action.equalsIgnoreCase("updateProducto")) {
            String id = request.getParameter("txtid");
            String nom = request.getParameter("txtnombre");
            String precio = request.getParameter("txtprecio");
            String stock = request.getParameter("txtstock");
            String descripcion = request.getParameter("txtdescripcion");
            pro.setIdproductos(Integer.parseInt(id));
            pro.setNombre(nom);
            pro.setPrecio(Double.parseDouble(precio));
            pro.setStock(Integer.parseInt(stock));
            pro.setDescripcion(descripcion);
            dad.editProductos(pro);
            acceso = listarProductos;
        } else if (action.equalsIgnoreCase("delete")) {
            int id = Integer.parseInt(request.getParameter("id"));
            pro.setIdproductos(id);
            dad.eliminar(id);
            acceso = listarProductos;
        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
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
