/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDAD;

import config.conexion;
import interfaces.crud_productos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Empleados;
import modelo.Productos;


public class ProductosDAO implements crud_productos{

    conexion cn = new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Productos pro = new Productos();
    
    @Override
    public List listarProductos() {
        ArrayList<Productos> list = new ArrayList<>();
        String sql = "select * from productos;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Productos pro = new Productos();
                pro.setIdproductos(rs.getInt("idproductos"));
                pro.setNombre(rs.getString("Nombre"));
                pro.setPrecio(rs.getDouble("Precio"));
                pro.setStock(rs.getInt("Stock"));
                pro.setDescripcion(rs.getString("Descripcion"));
                list.add(pro);
            }
        } catch (Exception ex) {

        }
        return list;
    }

    @Override
    public Productos list(int id) {
        String sql = "select * from productos where idproductos = '"+id+"';";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                pro.setIdproductos(rs.getInt("idproductos"));
                pro.setNombre(rs.getString("Nombre"));
                pro.setPrecio(rs.getDouble("Precio"));
                pro.setStock(rs.getInt("Stock"));
                pro.setDescripcion(rs.getString("Descripcion"));
            }
        } catch (Exception ex) {

        }
        return pro;
    }

    @Override
    public boolean addProductos(Productos pro) {
        String sql = "insert into productos values('"+pro.getIdproductos()+"','"+pro.getNombre()+"','"+pro.getPrecio()+"',"
                + "'"+pro.getStock()+"','"+pro.getDescripcion()+"');";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception ex) {

        }
        return false;
    }

    @Override
    public boolean editProductos(Productos pro) {
        String sql = "update productos set Nombre = '"+pro.getNombre()+"', Precio = '"+pro.getPrecio()+"',"
                + " Stock = '"+pro.getStock()+"', Descripcion = '"+pro.getDescripcion()+"' where idProductos = '"+pro.getIdproductos()+"';";
        try{
            con = cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        }
        catch(Exception ex){
        
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "delete from productos where idproductos = '"+id+"';";
        try{
            con = cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        }
        catch(Exception ex){
        
        }
        return false;
    }
    
}
