<%-- 
    Document   : editEmpleados
    Created on : 06-08-2022, 07:36:33 PM
    Author     : angel
--%>

<%@page import="modelo.Empleados"%>
<%@page import="modeloDAD.EmpleadosDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <title>Editar Empleados</title>
    </head>
    <body>
        <%
            EmpleadosDAO dad = new EmpleadosDAO();
            int id = Integer.parseInt((String)request.getAttribute("idEmp"));
            Empleados emp = (Empleados)dad.list(id);
        %>
        <h1>Editar Empleado</h1>
        <form action="ControladorEmpleados">
            <div class="col-4">
                ID:<br>
            <input class="form-control" type="text" name="txtid" value="<%= emp.getId() %>"><br>
            Nombre:<br>
            <input class="form-control" type="text" name="txtNombre" value="<%= emp.getNombre() %>"><br>
            Apellido:<br>
            <input class="form-control" type="text" name="txtApellido" value="<%= emp.getApellido() %>"><br>
            Telefono:<br>
            <input class="form-control" type="text" name="txtTelefono" value="<%= emp.getTelefono() %>"><br>
            Direccion:<br>
            <input class="form-control" type="text" name="txtDireccion" value="<%= emp.getDireccion() %>"><br>
            Correo Electronico<br>
            <input class="form-control" type="text" name="txtCorreo" value="<%= emp.getCorreo() %>"><br>
            <input class="btn btn-primary" type="submit" name="accion" value="updateEmpleado"><br>
            </div>
            
            <a href="ControladorEmpleados?accion=listarEmpleados">Regresar</a>
        </form>
    </body>
</html>
