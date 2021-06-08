/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author JJ
 */
@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pagina = request.getParameter("pagina");
        if (pagina != null) {
            switch (pagina) {
                case "Ventas":
                    Inicio(request, response);
                    break;
                case "Usuarios":
                    Usuarios(request, response);
                    break;
                case "Productos":
                    Productos(request, response);
                    break;
                case "Categorias":
                    Categorias(request, response);
                    break;
                case "Detalles":
                    Detalles(request, response);
                    break;
                default:
                    Inicio(request, response);
            }
        } else {
            Inicio(request, response);
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pagina = request.getParameter("pagina");
        if (pagina != null) {
            switch (pagina) {
                case "Ventas":
                    Inicio(request, response);
                    break;
                case "Usuarios":
                    Usuarios(request, response);
                    break;
                case "Productos":
                    Productos(request, response);
                    break;
                case "Categorias":
                    Categorias(request, response);
                    break;
                case "Detalles":
                    Detalles(request, response);
                    break;
                default:
                    Inicio(request, response);
            }
        } else {
            Inicio(request, response);
        }
    }

    private void Detalles(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        DetalleVentaDAO dao = new DetalleVentaDAO();

        List<DetalleVenta> detalles = dao.listar();
        sesion.setAttribute("detalles", detalles);

        response.sendRedirect("DetallesVentas.jsp");
    }

    private void Usuarios(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "insertar":
                    insertarUsuario(request, response);
                    break;
                case "editar":
                    editarUsuario(request, response);
                    break;
                case "modificar":
                    actualizarUsuario(request, response);
                    break;
                case "eliminar":
                    eliminarUsuario(request, response);
                    break;
                default:
                    listarUsuarios(request, response);
            }
        } else {
            listarUsuarios(request, response);
        }
    }

    private void insertarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nc = request.getParameter("id");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String direccion = request.getParameter("direccion");
        String telefono = request.getParameter("telefono");
        String correo = request.getParameter("correo");
        String contrasena = request.getParameter("contrasena");
        String tipou = request.getParameter("tipou");

        Usuario usuario = new Usuario(Integer.parseInt(nc), nombre, apellido, direccion,
                telefono, correo, contrasena, Integer.parseInt(tipou));

        UsuarioDAO dao = new UsuarioDAO();

        int registrosModificados = dao.insertar(usuario);

        //redirigimos
        listarUsuarios(request, response);
    }

    private void listarUsuarios(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sesion = request.getSession();
        UsuarioDAO dao = new UsuarioDAO();

        List<Usuario> usuarios = dao.listar();
        sesion.setAttribute("usuarios", usuarios);

        response.sendRedirect("usuarios.jsp");
    }

    private void editarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperra el id
        int id = Integer.parseInt(request.getParameter("nc"));

        //recuperar datos de la base de datos
        UsuarioDAO dao = new UsuarioDAO();
        Usuario usuario = dao.encontrar(id);

        request.setAttribute("usuario", usuario);
        String jspEditar = "/WEB-INF/paginas/editar/editarUsuario.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);

    }

    private void actualizarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nc = request.getParameter("id");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String direccion = request.getParameter("direccion");
        String telefono = request.getParameter("telefono");
        String correo = request.getParameter("correo");
        String contrasena = request.getParameter("contrasena");
        String tipou = request.getParameter("tipou");

        Usuario usuario = new Usuario(Integer.parseInt(nc), nombre, apellido, direccion,
                telefono, correo, contrasena, Integer.parseInt(tipou));

        UsuarioDAO dao = new UsuarioDAO();

        int registrosModificados = dao.actualizar(usuario);

        System.out.println("registros modificados = " + registrosModificados);

        //redirigimos
        listarUsuarios(request, response);
    }

    private void eliminarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //recuperra el id 
        int id = Integer.parseInt(request.getParameter("nc"));

        UsuarioDAO dao = new UsuarioDAO();
        int registrosModificados = dao.eliminar(id);

        System.out.println("registros eliminados = " + registrosModificados);

        listarUsuarios(request, response);
    }

    private void Categorias(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "insertar":
                    insertarCategoria(request, response);
                    break;
                case "editar":
                    editarCategoria(request, response);
                    break;
                case "modificar":
                    actualizarCategoria(request, response);
                    break;
                case "eliminar":
                    eliminarCategoria(request, response);
                    break;
                default:
                    listarCategorias(request, response);
            }
        } else {
            listarCategorias(request, response);
        }
    }

    private void insertarCategoria(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nc = request.getParameter("id");
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");

        Categoria cat = new Categoria(Integer.parseInt(nc), nombre, descripcion);

        CategoriaDAO dao = new CategoriaDAO();

        int registrosModificados = dao.insertar(cat);

        //redirigimos
        listarCategorias(request, response);
    }

    private void listarCategorias(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sesion = request.getSession();
        CategoriaDAO dao = new CategoriaDAO();

        List<Categoria> categorias = dao.listar();
        sesion.setAttribute("categorias", categorias);
        sesion.setAttribute("categoriasTotales", categorias.size());

        response.sendRedirect("categorias.jsp");

    }

    private void editarCategoria(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperra el id
        int id = Integer.parseInt(request.getParameter("nc"));

        //recuperar datos de la base de datos
        CategoriaDAO dao = new CategoriaDAO();
        Categoria cat = dao.encontrar(id);

        request.setAttribute("categoria", cat);
        String jspEditar = "/WEB-INF/paginas/editar/editarCategoria.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);

    }

    private void actualizarCategoria(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nc = request.getParameter("id");
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");

        Categoria cat = new Categoria(Integer.parseInt(nc), nombre, descripcion);
        CategoriaDAO dao = new CategoriaDAO();

        int registrosModificados = dao.actualizar(cat);

        System.out.println("registros modificados = " + registrosModificados);

        //redirigimos
        listarCategorias(request, response);
    }

    private void eliminarCategoria(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //recuperra el id 
        int id = Integer.parseInt(request.getParameter("nc"));

        CategoriaDAO dao = new CategoriaDAO();
        int registrosModificados = dao.eliminar(id);

        System.out.println("registros eliminados = " + registrosModificados);

        listarCategorias(request, response);
    }

    private void Productos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "insertar":
                    insertarProducto(request, response);
                    break;
                case "editar":
                    editarProducto(request, response);
                    break;
                case "modificar":
                    actualizarProducto(request, response);
                    break;
                case "eliminar":
                    eliminarProducto(request, response);
                    break;
                default:
                    listarProductos(request, response);
            }
        } else {
            listarProductos(request, response);
        }
    }

    private void insertarProducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nc = request.getParameter("id");
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        String cantidad = request.getParameter("cantidad");
        String pcompra = request.getParameter("pcompra");
        String pventa = request.getParameter("pventa");
        String presentacion = request.getParameter("presentacion");
        String categoria = request.getParameter("categoria");

        Producto prod = new Producto(Integer.parseInt(nc), nombre, descripcion, Integer.parseInt(cantidad),
                Float.parseFloat(pcompra), Float.parseFloat(pventa), presentacion, Integer.parseInt(categoria));

        ProductoDAO dao = new ProductoDAO();

        int registrosModificados = dao.insertar(prod);

        //redirigimos
        listarProductos(request, response);
    }

    private void listarProductos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sesion = request.getSession();
        ProductoDAO dao = new ProductoDAO();

        List<Producto> productos = dao.listar();
        sesion.setAttribute("productos", productos);

        response.sendRedirect("productos.jsp");
    }

    private void editarProducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperra el id
        int id = Integer.parseInt(request.getParameter("nc"));

        //recuperar datos de la base de datos
        ProductoDAO dao = new ProductoDAO();
        Producto producto = dao.encontrar(id);

        request.setAttribute("producto", producto);
        String jspEditar = "/WEB-INF/paginas/editar/editarProducto.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
    }

    private void actualizarProducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nc = request.getParameter("id");
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        String cantidad = request.getParameter("cantidad");
        String pcompra = request.getParameter("pcompra");
        String pventa = request.getParameter("pventa");
        String presentacion = request.getParameter("presentacion");
        String categoria = request.getParameter("categoria");

        Producto prod = new Producto(Integer.parseInt(nc), nombre, descripcion, Integer.parseInt(cantidad),
                Float.parseFloat(pcompra), Float.parseFloat(pventa), presentacion, Integer.parseInt(categoria));

        ProductoDAO dao = new ProductoDAO();

        int registrosModificados = dao.actualizar(prod);

        //redirigimos
        listarProductos(request, response);
    }

    private void eliminarProducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //recuperra el id 
        int id = Integer.parseInt(request.getParameter("nc"));

        ProductoDAO dao = new ProductoDAO();
        int registrosModificados = dao.eliminar(id);

        System.out.println("registros eliminados = " + registrosModificados);

        listarProductos(request, response);
    }

    private void Inicio(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "insertar":
                    insertarVenta(request, response);
                    break;
                default:
                    listarVenta(request, response);
            }
        } else {
            listarVenta(request, response);
        }
    }

    private void listarVenta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        VentaDAO dao = new VentaDAO();
        ProductoDAO daoproducto = new ProductoDAO();
        List<Venta> ventas = dao.listar();
        List<Producto> productos = daoproducto.listar();

        //los datos se pierden cuando llamamos a senredirect por eso hacemos una var session para guardarlos por mas tiempo los datos
        HttpSession sesion = (HttpSession) request.getSession();
        sesion.setAttribute("vent_productos", productos);
        sesion.setAttribute("ventas", ventas);
        response.sendRedirect("Inicio.jsp");
    }

    private void insertarVenta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");
        String ingreso = request.getParameter("ingreso");
        String total = request.getParameter("total");
        String idusuario = request.getParameter("idusuario");
        String[] productosVendidos = request.getParameterValues("prod");
        String[] idProd = request.getParameterValues("id_producto");

        List<String> prodVendidos = new ArrayList<String>();
        prodVendidos = Arrays.asList(productosVendidos);
        List<String> idProductos = new ArrayList<String>();
        idProductos = Arrays.asList(idProd);

        DetalleVenta detalleVenta = null;
        DetalleVentaDAO daodetalles = new DetalleVentaDAO();

        Venta venta = new Venta(Integer.parseInt(id), Double.parseDouble(ingreso), Double.parseDouble(total), Integer.parseInt(idusuario));

        VentaDAO dao = new VentaDAO();

        int registrosModificados = dao.insertar(venta);

        for (int i = 0; i < prodVendidos.size(); i++) {
            if (!prodVendidos.get(i).equals("0")) {
                detalleVenta = new DetalleVenta(Integer.parseInt(id), Integer.parseInt(idProductos.get(i)), Integer.parseInt(prodVendidos.get(i)));
                daodetalles.insertar(detalleVenta);
            }
        }

        //redirigimos
        listarVenta(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
