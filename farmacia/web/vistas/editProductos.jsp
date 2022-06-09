<%-- 
    Document   : editProductos
    Created on : 06-08-2022, 09:23:32 PM
    Author     : angel
--%>

<%@page import="modelo.Productos"%>
<%@page import="modeloDAD.ProductosDAO"%>
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
            ProductosDAO dad = new ProductosDAO();
            int id = Integer.parseInt((String)request.getAttribute("idProd"));
            Productos pro = (Productos)dad.list(id);
        %>
        <h1>Editar Cliente</h1>
        <form action="ControladorProductos">
            <div class="col-4">
                ID:<br>
            <input class="form-control" type="text" name="txtid" value="<%= pro.getIdproductos() %>"><br>
            Nombre:<br>
            <input class="form-control" type="text" name="txtnombre" value="<%= pro.getNombre() %>"><br>
            Precio<br>
            <input class="form-control" type="text" name="txtprecio" value="<%= pro.getPrecio() %>"><br>
            Stock<br>
            <input class="form-control" type="text" name="txtstock" value="<%= pro.getStock() %>"><br>
            Descripcion:<br>
            <input class="form-control" type="text" name="txtdescripcion" value="<%= pro.getDescripcion() %>"><br>
            <input class="btn btn-primary" type="submit" name="accion" value="updateProducto"><br>
            </div>
            
            <a href="ControladorProductos?accion=listarProductos">Regresar</a>
        </form>
    </body>
</html>
