/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDAD;

import config.conexion;
import interfaces.crud_clientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Clientes;


public class ClientesDAO implements crud_clientes{
    conexion cn = new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Clientes cli = new Clientes();

    @Override
    public List listarClientes() {
        ArrayList<Clientes> list = new ArrayList<>();
        String sql = "select * from clientes;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Clientes cli = new Clientes();
                cli.setId(rs.getInt("idClientes"));
                cli.setNombre(rs.getString("Nombre"));
                cli.setApellido(rs.getString("Apellido"));
                cli.setTelefono(rs.getInt("Telefono"));
                cli.setDireccion(rs.getString("Direccion"));
                cli.setCorreo(rs.getString("Correo_electronico"));
                list.add(cli);
            }
        } catch (Exception ex) {

        }
        return list;
    }

    @Override
    public Clientes list(int id) {
        String sql = "select * from clientes where idClientes = '" + id + "';";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cli.setId(rs.getInt("idClientes"));
                cli.setNombre(rs.getString("Nombre"));
                cli.setApellido(rs.getString("Apellido"));
                cli.setTelefono(rs.getInt("Telefono"));
                cli.setDireccion(rs.getString("Direccion"));
                cli.setCorreo(rs.getString("Correo_electronico"));
            }
        } catch (Exception ex) {

        }
        return cli;
    }

    @Override
    public boolean addClientes(Clientes cli) {
        String sql = "insert into clientes values('" + cli.getId() + "','" + cli.getNombre() + "','" + cli.getApellido() + "',"
                + "'" + cli.getTelefono() + "','" + cli.getDireccion() + "','" + cli.getCorreo() + "');";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception ex) {

        }
        return false;
    }

    @Override
    public boolean editClientes(Clientes cli) {

        String sql = "update clientes set Nombre = '" + cli.getNombre() + "', Apellido = '" + cli.getApellido() + "', Telefono = '" + cli.getTelefono() + "', Direccion = '" + cli.getDireccion() + "', Correo_electronico = '" + cli.getCorreo() + "' where idclientes = '" + cli.getId() + "'";
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
        String sql = "delete from clientes where idclientes = '"+id+"';";
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
