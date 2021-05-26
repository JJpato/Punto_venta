package Modelo;

import configuracion.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ProductoDAO{
    
    private static final String SQL_SELECT = "SELECT * FROM producto";
    private static final String SQL_SELECT_BY_NC = "SELECT * FROM producto WHERE id_producto = ?";
    private static final String SQL_INSERT = "INSERT INTO producto VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE producto SET id_producto = ? , nombre = ?, "
            + "descripcion = ?, inventario = ?, precio_compra = ?, precio_venta = ?, "
            + "presentacion = ?, id_categoria = ? WHERE nc = ?";
    private static final String SQL_DELETE = "DELETE FROM producto WHERE nc = ?";

    public List listar() {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Producto> productos = new ArrayList<>();  
        
        try{
            con = Conexion.getConexion();
            stmt =  con.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            Producto producto = null;
            
            while(rs.next()){
                producto = new Producto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), (float)rs.getDouble(5), (float)rs.getDouble(6), rs.getString(7), rs.getInt(8));
                productos.add(producto);
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
        return productos;
    }

    public Producto encontrar(int id) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Producto producto=null;        
        try{
            con = Conexion.getConexion();
            stmt = con.prepareStatement(SQL_SELECT_BY_NC);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
            rs.absolute(1);
            
            producto = new Producto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), (float)rs.getDouble(5), (float)rs.getDouble(6), rs.getString(7), rs.getInt(8));
        }
        catch(SQLException ex){
            ex.printStackTrace(System.out);
        }
        finally{
            Conexion.cerrar(rs);
            Conexion.cerrar(stmt);
            Conexion.cerrar(con);
        }       
        return producto;
    }

    public int insertar(Producto prod) {
        Connection con = null;
        PreparedStatement stmt = null;
        int rows=0;
        try{
            con = Conexion.getConexion();
            stmt = con.prepareStatement(SQL_INSERT);
            stmt.setInt(1, prod.getId());
            stmt.setString(2, prod.getNombre());
            stmt.setString(3, prod.getDescripcion());
            stmt.setInt(4, prod.getCantidadInventario());
            stmt.setDouble(5, prod.getPrecioDeCompra());
            stmt.setDouble(6, prod.getPrecioDeVenta());
            stmt.setString(7, prod.getPresentacion());
            stmt.setInt(8, prod.getIdCategoria());
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

    public int actualizar(Producto prod) {
        Connection con = null;
        PreparedStatement stmt = null;
        int rows=0;
        try{
            con = Conexion.getConexion();
            stmt = con.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, prod.getId());
            stmt.setString(2, prod.getNombre());
            stmt.setString(3, prod.getDescripcion());
            stmt.setInt(4, prod.getCantidadInventario());
            stmt.setDouble(5, prod.getPrecioDeCompra());
            stmt.setDouble(6, prod.getPrecioDeVenta());
            stmt.setString(7, prod.getPresentacion());
            stmt.setInt(8, prod.getIdCategoria());
            stmt.setInt(9, prod.getId());
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
