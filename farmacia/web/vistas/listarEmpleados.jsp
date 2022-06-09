<%-- 
    Document   : listarEmpleados
    Created on : 06-08-2022, 07:52:34 PM
    Author     : angel
--%>

<%@page import="modeloDAD.EmpleadosDAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Empleados"%>
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
            <a href="ControladorEmpleados?accion=addEmpleado">Agregar Nuevo</a>
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
                    EmpleadosDAO dao= new EmpleadosDAO();
                    List<Empleados> list = dao.listarEmpleados();
                    Iterator<Empleados> iter = list.iterator();
                    Empleados emp = null;
                    while(iter.hasNext()){
                        emp=iter.next();
                    
                %>
                <tbody>
                    <tr>
                        <td><%= emp.getId()%></td>
                        <td><%= emp.getNombre()%></td>
                        <td><%= emp.getApellido()%></td>
                        <td><%= emp.getTelefono()%></td>
                        <td><%= emp.getDireccion()%></td>
                        <td><%= emp.getCorreo()%></td>
                        <td>
                            <a href="ControladorEmpleados?accion=edit&id=<%= emp.getId()%>">Editar</a>
                            <a href="ControladorEmpleados?accion=delete&id=<%= emp.getId()%>">Eliminar</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
    </body>
</html>
