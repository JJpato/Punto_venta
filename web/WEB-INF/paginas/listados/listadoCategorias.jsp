
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section id="categorias">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="card">
                    <div class="card-header">
                        <h4>Listado de Categorias <jsp:include page="/WEB-INF/paginas/botones_modal/boton_agregar_categoria.jsp"/></h4>
                    </div>
                    <table class="table table-striped">
                        <thead class="thead-dark">
                            <tr>
                                <th>#</th>
                                <th>Nombre</th>
                                <th>Descripcion</th>            
                            </tr>
                        </thead>
                        <tbody>
                            <!--Iteramos cada elemento de la lista -->
                            <c:forEach var="categorias" items="${categorias}">
                                <tr>
                                    <td>${categorias.getId()}</td>
                                    <td>${categorias.getNombre()}</td> 
                                    <td>${categorias.getDescripcion()}</td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/Controlador?pagina=Categorias&accion=editar&nc=${categorias.getId()}"
                                           class="btn btn-primary btn-block" >
                                            <i class="fas fa-angle-double-right"></i>Editar
                                        </a>
                                        <a href="${pageContext.request.contextPath}/Controlador?pagina=Categorias&accion=eliminar&nc=${categorias.getId()}" 
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

            <!-- Inicio Targetas para los totales-->
            <div class="col md-3">
                <div class="card text-center bg-success text-white mb-3">
                    <div class="card-body">
                        <h3>Categorias totales</h3>
                        <h4 class="display-4">
                            <i class="fab fa-buffer"></i> ${categoriasTotales}
                        </h4>
                    </div>
                </div>
            </div>
            <!-- Cierre Targetas para los totales-->
        </div>
    </div>
</section>
                        
<!-- Modal agregar Categoria-->
<jsp:include page="/WEB-INF/paginas/agregar/agregarCategoria.jsp"/>