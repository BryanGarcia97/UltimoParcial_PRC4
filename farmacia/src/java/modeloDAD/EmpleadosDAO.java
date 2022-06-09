/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDAD;

import config.conexion;
import interfaces.crud_empleados;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Empleados;


public class EmpleadosDAO implements crud_empleados{
    conexion cn = new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Empleados emp = new Empleados();
    
    @Override
    public List listarEmpleados() {
        ArrayList<Empleados> list = new ArrayList<>();
        String sql = "select * from empleado;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Empleados emp = new Empleados();
                emp.setId(rs.getInt("idempleado"));
                emp.setNombre(rs.getString("Nombre"));
                emp.setApellido(rs.getString("Apellido"));
                emp.setTelefono(rs.getInt("Telefono"));
                emp.setDireccion(rs.getString("Direccion"));
                emp.setCorreo(rs.getString("Correo_electronico"));
                list.add(emp);
            }
        } catch (Exception ex) {

        }
        return list;
    }

    @Override
    public Empleados list(int id) {
        String sql = "select * from empleado where idempleado = '" + id + "';";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                emp.setId(rs.getInt("idempleado"));
                emp.setNombre(rs.getString("Nombre"));
                emp.setApellido(rs.getString("Apellido"));
                emp.setTelefono(rs.getInt("Telefono"));
                emp.setDireccion(rs.getString("Direccion"));
                emp.setCorreo(rs.getString("Correo_electronico"));
            }
        } catch (Exception ex) {

        }
        return emp;
    }

    @Override
    public boolean addEmpleados(Empleados emp) {
        String sql = "insert into empleado values('" + emp.getId() + "','" + emp.getNombre() + "','" + emp.getApellido() + "',"
                + "'" + emp.getTelefono() + "','" + emp.getDireccion() + "','" + emp.getCorreo() + "');";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception ex) {

        }
        return false;
    }

    @Override
    public boolean editEmpleados(Empleados emp) {
        String sql = "update empleado set Nombre = '" + emp.getNombre() + "', Apellido = '" + emp.getApellido() + "', Telefono = '" + emp.getTelefono() + "', Direccion = '" + emp.getDireccion() + "', Correo_electronico = '" + emp.getCorreo() + "' where idempleado = '" + emp.getId() + "'";
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
        String sql = "delete from empleado where idempleado = '"+id+"';";
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
