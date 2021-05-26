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
public class CategoriaDAO {

    private static final String SQL_SELECT = "SELECT * FROM categoria";
    private static final String SQL_SELECT_BY_NC = "SELECT * FROM categoria WHERE id_producto = ?";
    private static final String SQL_INSERT = "INSERT INTO categoria VALUES (?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE categoria SET id_categoria = ? , nombre = ?, descripcion = ? WHERE nc = ?";
    private static final String SQL_DELETE = "DELETE FROM categoria WHERE nc = ?";

    public List listar() {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Categoria> categorias = new ArrayList<>();  
        
        try{
            con = Conexion.getConexion();
            stmt =  con.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            Categoria categoria = null;
            
            while(rs.next()){
                categoria = new Categoria(rs.getInt(1), rs.getString(2), rs.getString(3));
                categorias.add(categoria);
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
        return categorias;
    }

    public Categoria encontrar(int id) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Categoria categoria = null;
        try{
            con = Conexion.getConexion();
            stmt = con.prepareStatement(SQL_SELECT_BY_NC);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
            rs.absolute(1);
            
            categoria = new Categoria(rs.getInt(1), rs.getString(2), rs.getString(3));
        }
        catch(SQLException ex){
            ex.printStackTrace(System.out);
        }
        finally{
            Conexion.cerrar(rs);
            Conexion.cerrar(stmt);
            Conexion.cerrar(con);
        }       
        return categoria;
    }

    public int insertar(Categoria categoria) {
        Connection con = null;
        PreparedStatement stmt = null;
        int rows=0;
        try{
            con = Conexion.getConexion();
            stmt = con.prepareStatement(SQL_INSERT);
            stmt.setInt(1, categoria.getId());
            stmt.setString(2, categoria.getNombre());
            stmt.setString(3, categoria.getDescripcion());
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

    public int actualizar(Categoria categoria) {
        Connection con = null;
        PreparedStatement stmt = null;
        int rows=0;
        try{
            con = Conexion.getConexion();
            stmt = con.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, categoria.getId());
            stmt.setString(2, categoria.getNombre());
            stmt.setString(3, categoria.getDescripcion());
            stmt.setInt(4, categoria.getId());
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
  
