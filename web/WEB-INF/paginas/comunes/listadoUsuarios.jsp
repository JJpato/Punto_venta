
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section id="usuarios">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="card">
                    <div class="card-header">
                        <h4>Listado de Usuarios</h4>
                    </div>
                    <table class="table table-striped">
                        <thead class="thead-dark">
                            <tr>
                                <th>#</th>
                                <th>Nombre</th>
                                <th>Direccion</th>
                                <th></th>                   
                            </tr>
                        </thead>
                        <tbody>
                            <!--Iteramos cada elemento de la lista de clientes -->
                            <c:forEach var="usuarios" items="${usuarios}">
                                <tr>
                                    <td>${usuarios.getId()}</td>
                                    <td>${usuarios.getNombre()}</td> 
                                    <td>${usuarios.getDireccion()}</td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/Controlador?accion=editar&nc=${alumnos.getNc()}"
                                           class="btn btn-primary btn-block" >
                                            <i class="fas fa-angle-double-right"></i>Editar
                                        </a>
                                        <a href="${pageContext.request.contextPath}/Controlador?accion=eliminar&nc=${alumnos.getNc()}" class="btn btn-secondary btn-block">
                                            <i class="fas fa-trash"></i> Eliminar
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>

            <!-- Inicio Targetas para los totales-->
            <div class="col md-3">
                <div class="card text-center bg-success text-white mb-3">
                    <div class="card-body">
                        <h3>Usuarios totales</h3>
                        <h4 class="display-4">
                            <i class="fas fa-users"></i> ${usuariosTotales}
                        </h4>
                    </div>
                </div>
            </div>
            <!-- Cierre Targetas para los totales-->
        </div>
    </div>
</section>

<!-- Modal agregar alumno-->
<jsp:include page="/WEB-INF/paginas/comunes/agregarAlumno.jsp"/>
