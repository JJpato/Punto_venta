package Modelo;

import configuracion.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    private static final String SQL_SELECT = "SELECT * FROM usuario";
    private static final String SQL_SELECT_BY_NC = "SELECT * FROM usuario WHERE id_usuario = ?";
    private static final String SQL_SELECT_BY_USUS_CONT = "SELECT * FROM usuario WHERE correo = ? and contrasena = ?";
    private static final String SQL_INSERT = "INSERT INTO usuario VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE usuario SET id_usuario = ? , nombres = ?, "
            + "apellidos = ?, direccion = ?, telefono = ?, correo = ?, "
            + "contrasena = ?, tipo_usuario = ? WHERE nc = ?";
    private static final String SQL_DELETE = "DELETE FROM usuario WHERE nc = ?";

    public List listar() {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Usuario> usuarios = new ArrayList<>();

        try {
            con = Conexion.getConexion();
            stmt = con.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            Usuario usuario = null;

            while (rs.next()) {
                usuario = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8));
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.cerrar(rs);
            Conexion.cerrar(stmt);
            Conexion.cerrar(con);
        }
        return usuarios;
    }

    public Usuario encontrar(int nc) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario usuario = null;
        try {
            con = Conexion.getConexion();
            stmt = con.prepareStatement(SQL_SELECT_BY_NC);
            stmt.setInt(1, nc);
            rs = stmt.executeQuery();

            rs.absolute(1);

            usuario = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8));
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.cerrar(rs);
            Conexion.cerrar(stmt);
            Conexion.cerrar(con);
        }
        return usuario;
    }

    public int insertar(Usuario usuario) {
        Connection con = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            con = Conexion.getConexion();
            stmt = con.prepareStatement(SQL_INSERT);
            stmt.setInt(1, usuario.getId());
            stmt.setString(2, usuario.getNombre());
            stmt.setString(3, usuario.getApellido());
            stmt.setString(4, usuario.getDireccion());
            stmt.setString(5, usuario.getTelefono());
            stmt.setString(6, usuario.getCorreo());
            stmt.setString(7, usuario.getContrasena());
            stmt.setInt(8, usuario.getTipoUsuario());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.cerrar(stmt);
            Conexion.cerrar(con);
        }
        return rows;
    }

    public int actualizar(Usuario usuario) {
        Connection con = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            con = Conexion.getConexion();
            stmt = con.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, usuario.getId());
            stmt.setString(2, usuario.getNombre());
            stmt.setString(3, usuario.getApellido());
            stmt.setString(4, usuario.getDireccion());
            stmt.setString(5, usuario.getTelefono());
            stmt.setString(6, usuario.getCorreo());
            stmt.setString(7, usuario.getContrasena());
            stmt.setInt(8, usuario.getTipoUsuario());
            stmt.setInt(9, usuario.getId());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.cerrar(stmt);
            Conexion.cerrar(con);
        }
        return rows;
    }

    public int eliminar(int id) {
        Connection con = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            con = Conexion.getConexion();
            stmt = con.prepareStatement(SQL_DELETE);
            stmt.setInt(1, id);
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.cerrar(stmt);
            Conexion.cerrar(con);
        }
        return rows;
    }

    public Usuario inicioSesion(String usu, String contrasena) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario usuario = null;
        
        try {
            con = Conexion.getConexion();
            stmt = con.prepareStatement(SQL_SELECT_BY_USUS_CONT);
            stmt.setString(1, usu);
            stmt.setString(2, contrasena);
            rs = stmt.executeQuery();

            //rs.absolute(1);
            while (rs.next()) {
                usuario = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8));
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.cerrar(rs);
            Conexion.cerrar(stmt);
            Conexion.cerrar(con);
        }
        return usuario;
    }

}
