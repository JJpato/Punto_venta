/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;
import java.io.IOException;
import java.io.PrintWriter;
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
                default:
                    Inicio(request, response);
            }
        } else {
            Inicio(request, response);
        }
    }

    private void insertarAlumno(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*
        String nc = request.getParameter("nc");
        String nombre = request.getParameter("nombre");
        String direccion = request.getParameter("direccion");
        
        Alumno alum = new Alumno(Integer.parseInt(nc), nombre, direccion);
        
        AlumnoDAO dao = new AlumnoDAO();
        int registrosModificados = dao.insertar(alum);
        
        //redirigimos a la accion por default
        consultarAlumnos(request, response);
         */
    }

    private void Usuarios(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UsuarioDAO dao = new UsuarioDAO();
        List<Usuario> usuarios = dao.listar();

        //los datos se pierden cuando llamamos a senredirect por eso hacemos una var session para guardarlos por mas tiempo los datos
        HttpSession sesion = (HttpSession) request.getSession();
        sesion.setAttribute("usuarios", usuarios);
        sesion.setAttribute("usuariosTotales", usuarios.size());
        response.sendRedirect("usuarios.jsp");
         
    }
    
    private void Categorias(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CategoriaDAO dao = new CategoriaDAO();
        List<Categoria> categorias = dao.listar();
        
        //los datos se pierden cuando llamamos a senredirect por eso hacemos una var session para guardarlos por mas tiempo los datos
        HttpSession sesion = request.getSession();
        sesion.setAttribute("categorias", categorias);
        sesion.setAttribute("categoriasTotales", categorias.size());
        response.sendRedirect("categorias.jsp");
    }
    
    private void Productos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductoDAO dao = new ProductoDAO();
        List<Producto> productos = dao.listar();

        //los datos se pierden cuando llamamos a senredirect por eso hacemos una var session para guardarlos por mas tiempo los datos
        HttpSession sesion = request.getSession();
        sesion.setAttribute("productos", productos);
        //request.getRequestDispatcher("/consultar.jsp").forward(request, response);
        response.sendRedirect("productos.jsp");

    }

    private void Inicio(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        VentaDAO dao = new VentaDAO();
        List<Venta> ventas = dao.listar();

        //los datos se pierden cuando llamamos a senredirect por eso hacemos una var session para guardarlos por mas tiempo los datos
        HttpSession sesion = (HttpSession) request.getSession();
        sesion.setAttribute("ventas", ventas);
        //sesion.setAttribute("usuariosTotales", usuarios.size());
        //request.getRequestDispatcher("/consultar.jsp").forward(request, response);
        response.sendRedirect("Inicio.jsp");
    }

    private void editarAlumnos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperra el id
        /*
        int nCAlumno = Integer.parseInt(request.getParameter("nc"));
        //recuperar datos de la base de datos
        AlumnoDAO dao = new AlumnoDAO();
        Alumno alumno = dao.encontrar(nCAlumno);
        
        request.setAttribute("alumno", alumno);
        String jspEditar = "/WEB-INF/paginas/comunes/editarAlumno.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
         */
    }

    private void actualizarAlumno(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*
        String nc = request.getParameter("nc");
        String nombre = request.getParameter("nombre");
        String direccion = request.getParameter("direccion");
        
        Alumno alum = new Alumno(Integer.parseInt(nc), nombre, direccion);
        
        AlumnoDAO dao = new AlumnoDAO();
        int registrosModificados = dao.actualizar(alum);
        
        System.out.println("registros modificados = " + registrosModificados);
        
        //redirigimos a la accion por default
        consultarAlumnos(request, response);
         */
    }

    private void eliminarAlumnos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*
        //recuperra el id 
        int nCAlumno = Integer.parseInt(request.getParameter("nc"));
        
        AlumnoDAO dao = new AlumnoDAO();
        int registrosModificados = dao.eliminar(nCAlumno);
        
        System.out.println("registros eliminados = " + registrosModificados);
        
        consultarAlumnos(request, response);
         */
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
