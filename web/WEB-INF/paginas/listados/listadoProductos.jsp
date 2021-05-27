
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section id="productos">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="card">
                    <div class="card-header">
                        <h4>Listado de Productos</h4>
                    </div>
                    <table class="table table-striped">
                        <thead class="thead-dark">
                            <tr>
                                <th>#</th>
                                <th>Nombre</th>
                                <th>Descripcion</th>
                                <th></th>                   
                            </tr>
                        </thead>
                        <tbody>

                            <!--Iteramos cada elemento de la lista de productos -->
                            <c:forEach var="productos" items="${productos}">
                                <tr>
                                    <td>${productos.getId()}</td>
                                    <td>${productos.getNombre()}</td> 
                                    <td>${productos.getDescripcion()}</td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/Controlador?pagina=Productos&accion=editar&nc=${productos.getId()}"
                                           class="btn btn-primary btn-block" >
                                            <i class="fas fa-angle-double-right"></i>Editar
                                        </a>
                                        <a href="${pageContext.request.contextPath}/Controlador?pagina=Productos&accion=eliminar&nc=${productos.getId()}" 
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
                        <h3>Productos Totales totales</h3>
                        <h4 class="display-4">
                            <i class="fas fa-users"></i> ${productosTotales}
                        </h4>
                    </div>
                </div>
            </div>
            <!-- Cierre Targetas para los totales-->
        </div>
    </div>
</section>

