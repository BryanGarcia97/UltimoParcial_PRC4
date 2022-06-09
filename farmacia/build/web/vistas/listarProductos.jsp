<%-- 
    Document   : listarProductos
    Created on : 06-08-2022, 09:24:27 PM
    Author     : angel
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Productos"%>
<%@page import="modeloDAD.ProductosDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <title>Productos</title>
    </head>
    <body>
        <div>
            <h1>Productos</h1>
            <a href="ControladorProductos?accion=addProductos">Agregar Nuevo</a>
            <table class="table" border="1">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Precio</th>
                        <th>Stock</th>
                        <th>Descripcion</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <%
                    ProductosDAO dao= new ProductosDAO();
                    List<Productos> list = dao.listarProductos();
                    Iterator<Productos> iter = list.iterator();
                    Productos emp = null;
                    while(iter.hasNext()){
                        emp=iter.next();
                    
                %>
                <tbody>
                    <tr>
                        <td><%= emp.getIdproductos()%></td>
                        <td><%= emp.getNombre()%></td>
                        <td><%= emp.getPrecio()%></td>
                        <td><%= emp.getStock()%></td>
                        <td><%= emp.getDescripcion()%></td>
                        <td>
                            <a href="ControladorProductos?accion=edit&id=<%= emp.getIdproductos()%>">Editar</a>
                            <a href="ControladorProductos?accion=delete&id=<%= emp.getIdproductos()%>">Eliminar</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
    </body>
</html>
