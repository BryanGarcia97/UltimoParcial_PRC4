<%-- 
    Document   : addProductos
    Created on : 06-08-2022, 09:23:02 PM
    Author     : angel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <title>Agregar Productos</title>
    </head>
    <body>
        <h1>Agregar Producto</h1>
        <form action="ControladorProductos">
            <div class="col-4">
                ID:<br>
            <input class="form-control" type="text" name="txtid" ><br>
            Nombre:<br>
            <input class="form-control" type="text" name="txtnombre" ><br>
            Precio:<br>
            <input class="form-control" type="text" name="txtprecio" ><br>
            Stock:<br>
            <input class="form-control" type="text" name="txtstock" ><br>
            Descripcion:<br>
            <input class="form-control" type="text" name="txtdescripcion" ><br>
            <input class="btn btn-primary" type="submit" name="accion" value="saveProducto"><br>
            </div>
        </form>
    </body>
</html>
