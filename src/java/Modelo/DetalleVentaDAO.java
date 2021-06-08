/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import configuracion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JJ
 */
public class DetalleVentaDAO {
        
    private static final String SQL_SELECT = "SELECT * FROM detalles_venta";
    private static final String SQL_SELECT_BY_NC = "SELECT * FROM detalles_venta WHERE id_venta = ?";
    private static final String SQL_INSERT = "INSERT INTO detalles_venta VALUES (?, ?, ?)";

    public List listar() {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<DetalleVenta> detalleVentas = new ArrayList<>();  
        
        try{
            con = Conexion.getConexion();
            stmt =  con.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            DetalleVenta detalleVenta = null;
            
            while(rs.next()){
                detalleVenta = new DetalleVenta(rs.getInt(1), rs.getInt(2), rs.getInt(3));
                detalleVentas.add(detalleVenta);
            }
        }
        catch(SQLException ex){
            ex.printStackTrace(System.out);
        }
        finally{
            Conexion.cerrar(rs);
            Conexion.cerrar(stmt);
            Conexion.cerrar(con);
        }
        return detalleVentas;
    }

    public DetalleVenta encontrar(int id) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        DetalleVenta detalleVenta=null;        
        try{
            con = Conexion.getConexion();
            stmt = con.prepareStatement(SQL_SELECT_BY_NC);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
            rs.absolute(1);
            
            detalleVenta = new DetalleVenta(rs.getInt(1), rs.getInt(2), rs.getInt(3));
        }
        catch(SQLException ex){
            ex.printStackTrace(System.out);
        }
        finally{
            Conexion.cerrar(rs);
            Conexion.cerrar(stmt);
            Conexion.cerrar(con);
        }       
        return detalleVenta;
    }

    public int insertar(DetalleVenta detalles) {
        Connection con = null;
        PreparedStatement stmt = null;
        int rows=0;
        try{
            con = Conexion.getConexion();
            stmt = con.prepareStatement(SQL_INSERT);
            stmt.setInt(1, detalles.getIdVenta());
            stmt.setInt(2, detalles.getIdProducto());
            stmt.setInt(3, detalles.getCantidad());
            rows = stmt.executeUpdate();
        }
        catch(SQLException ex){
            ex.printStackTrace(System.out);
        }
        finally{
            Conexion.cerrar(stmt);
            Conexion.cerrar(con);
        }       
        return rows;
    }
    
}
