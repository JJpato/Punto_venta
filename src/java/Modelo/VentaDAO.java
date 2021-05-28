
package Modelo;

import configuracion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VentaDAO {
    
    private static final String SQL_SELECT = "SELECT * FROM venta";
    private static final String SQL_SELECT_BY_NC = "SELECT * FROM venta WHERE id_venta = ?";
    private static final String SQL_INSERT = "INSERT INTO venta VALUES (?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE venta SET id_venta = ?, "
            + "ingreso = ?, total = ?, id_usuario = ? WHERE id_venta = ?";
    private static final String SQL_DELETE = "DELETE FROM venta WHERE id_venta = ?";

    public List listar() {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Venta> ventas = new ArrayList<>();  
        
        try{
            con = Conexion.getConexion();
            stmt =  con.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            Venta venta = null;
            
            while(rs.next()){
                venta = new Venta(rs.getInt(1), rs.getDouble(2), rs.getDouble(3), rs.getInt(4));
                ventas.add(venta);
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
        return ventas;
    }

    public Venta encontrar(int id) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Venta venta=null;        
        try{
            con = Conexion.getConexion();
            stmt = con.prepareStatement(SQL_SELECT_BY_NC);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
            rs.absolute(1);
            
            venta = new Venta(rs.getInt(1), rs.getDouble(2), rs.getDouble(3), rs.getInt(4));
        }
        catch(SQLException ex){
            ex.printStackTrace(System.out);
        }
        finally{
            Conexion.cerrar(rs);
            Conexion.cerrar(stmt);
            Conexion.cerrar(con);
        }       
        return venta;
    }

    public int insertar(Venta venta) {
        Connection con = null;
        PreparedStatement stmt = null;
        int rows=0;
        try{
            con = Conexion.getConexion();
            stmt = con.prepareStatement(SQL_INSERT);
            stmt.setInt(1, venta.getId());
            stmt.setDouble(2, venta.getIngreso());
            stmt.setDouble(3, venta.getTotal());
            stmt.setInt(4, venta.getId_usuario());
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

    public int actualizar(Venta venta) {
        Connection con = null;
        PreparedStatement stmt = null;
        int rows=0;
        try{
            con = Conexion.getConexion();
            stmt = con.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, venta.getId());
            stmt.setDouble(2, venta.getIngreso());
            stmt.setDouble(3, venta.getTotal());
            stmt.setInt(4, venta.getId_usuario());
            stmt.setInt(5, venta.getId());
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

    public int eliminar(int nc) {
        Connection con = null;
        PreparedStatement stmt = null;
        int rows=0;
        try{
            con = Conexion.getConexion();
            stmt = con.prepareStatement(SQL_DELETE);
            stmt.setInt(1, nc);
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
