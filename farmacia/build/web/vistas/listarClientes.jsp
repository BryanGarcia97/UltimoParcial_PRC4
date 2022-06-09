<%-- 
    Document   : listarClientes
    Created on : 06-07-2022, 08:03:17 PM
    Author     : angel
--%>

<%@page import="modeloDAD.ClientesDAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Clientes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <title>Clientes</title>
    </head>
    <body>
        <div>
            <h1>Clientes</h1>
            <a href="ControladorClientes?accion=addCliente">Agregar Nuevo</a>
            <table class="table" border="1">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Telefono</th>
                        <th>Direccion</th>
                        <th>Correo Electronico</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <%
                    ClientesDAO dao= new ClientesDAO();
                    List<Clientes> list = dao.listarClientes();
                    Iterator<Clientes> iter = list.iterator();
                    Clientes cli = null;
                    while(iter.hasNext()){
                        cli=iter.next();
                    
                %>
                <tbody>
                    <tr>
                        <td><%= cli.getId()%></td>
                        <td><%= cli.getNombre()%></td>
                        <td><%= cli.getApellido()%></td>
                        <td><%= cli.getTelefono()%></td>
                        <td><%= cli.getDireccion()%></td>
                        <td><%= cli.getCorreo()%></td>
                        <td>
                            <a href="ControladorClientes?accion=edit&id=<%= cli.getId()%>">Editar</a>
                            <a href="ControladorClientes?accion=delete&id=<%= cli.getId()%>">Eliminar</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
    </body>
</html>
