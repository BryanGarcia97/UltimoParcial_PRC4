<%-- 
    Document   : addEmpleados
    Created on : 06-08-2022, 07:35:11 PM
    Author     : angel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
      <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <title>Agregar Empleados</title>
    </head>
    <body>
        <h1>Agregar Empleado</h1>
        <form action="ControladorEmpleados">
            <div class="col-4">
                ID:<br>
            <input class="form-control" type="text" name="txtid" ><br>
            Nombre:<br>
            <input class="form-control" type="text" name="txtNombre" ><br>
            Apellido:<br>
            <input class="form-control" type="text" name="txtApellido" ><br>
            Telefono:<br>
            <input class="form-control" type="text" name="txtTelefono" ><br>
            Direccion:<br>
            <input class="form-control"type="text" name="txtDireccion" ><br>
            Correo Electronico<br>
            <input class="form-control" type="text" name="txtCorreo" ><br>
            <input class="btn btn-primary" type="submit" name="accion" value="saveEmpleado"><br>
            </div>
        </form>
    </body>
</html>
