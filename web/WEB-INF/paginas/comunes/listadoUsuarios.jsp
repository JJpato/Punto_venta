
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section id="usuarios">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="card">
                    <div class="card-header">
                        <h4>Listado de Usuarios <jsp:include page="/WEB-INF/paginas/botones_modal/boton_agregar_usuario.jsp"/></h4>
                    </div>
                    <table class="table table-striped">
                        <thead class="thead-dark">
                            <tr>
                                <th>#</th>
                                <th>Nombre</th>
                                <th>Apellidos</th>
                                <th>Direccion</th>
                                <th>Telefono</th>   
                                <th>Correo</th>
                                <th>Tipo Usuario</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!--Iteramos cada elemento de la lista -->
                            <c:forEach var="usuarios" items="${usuarios}">
                                <tr>
                                    <td>${usuarios.getId()}</td>
                                    <td>${usuarios.getNombre()}</td> 
                                    <td>${usuarios.getApellido()}</td> 
                                    <td>${usuarios.getDireccion()}</td>
                                    <td>${usuarios.getTelefono()}</td>
                                    <td>${usuarios.getCorreo()}</td> 
                                    <td>${usuarios.getTipoUsuario()}</td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/Controlador?accion=editar&nc=${usuarios.getId()}"
                                           class="btn btn-primary btn-block" >
                                            <i class="fas fa-angle-double-right"></i>Editar
                                        </a>
                                        <a href="${pageContext.request.contextPath}/Controlador?accion=eliminar&nc=${usuarios.getId()}" 
                                           class="btn btn-secondary btn-block">
                                            <i class="fas fa-trash"></i> Eliminar
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</section>

<!-- Modal agregar alumno-->
<jsp:include page="/WEB-INF/paginas/agregar/agregarUsuario.jsp"/>
