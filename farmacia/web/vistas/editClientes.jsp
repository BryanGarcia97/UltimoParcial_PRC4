<%-- 
    Document   : editClientes
    Created on : 06-07-2022, 08:03:58 PM
    Author     : angel
--%>

<%@page import="modelo.Clientes"%>
<%@page import="modeloDAD.ClientesDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <title>Editar Clientes</title>
    </head>
    <body>
        <%
            ClientesDAO dad = new ClientesDAO();
            int id = Integer.parseInt((String)request.getAttribute("idCli"));
            Clientes cli = (Clientes)dad.list(id);
        %>
        <h1>Editar Cliente</h1>
        <form action="ControladorClientes">
            <div class="col-4">
                ID:<br>
            <input class="form-control" type="text" name="txtid" value="<%= cli.getId() %>"><br>
            Nombre:<br>
            <input class="form-control" type="text" name="txtNombre" value="<%= cli.getNombre() %>"><br>
            Apellido:<br>
            <input class="form-control" type="text" name="txtApellido" value="<%= cli.getApellido() %>"><br>
            Telefono:<br>
            <input class="form-control" type="text" name="txtTelefono" value="<%= cli.getTelefono() %>"><br>
            Direccion:<br>
            <input class="form-control"type="text" name="txtDireccion" value="<%= cli.getDireccion() %>"><br>
            Correo Electronico<br>
            <input class="form-control" type="text" name="txtCorreo" value="<%= cli.getCorreo() %>"><br>
            <input class="btn btn-primary" type="submit" name="accion" value="updateCliente"><br>
            </div>
            
            <a href="ControladorClientes?accion=listarClientes">Regresar</a>
        </form>
    </body>
</html>
