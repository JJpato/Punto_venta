
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section id="productos">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="card">
                    <div class="card-header">
                        
                        <h4>Listado de Productos <jsp:include page="/WEB-INF/paginas/botones_modal/boton_agregar_producto.jsp"/></h4>
                        
                    </div>
                    <table class="table table-striped">
                        <thead class="thead-dark">
                            <tr>
                                <th>#</th>
                                <th>Nombre</th>
                                <th>Descripcion</th>
                                <th>Cantidad</th>
                                <th>Precio Compra</th>
                                <th>Precio Venta</th>
                                <th>Presentacion</th>
                                <th>Categoria</th>
                            </tr>
                        </thead>
                        <tbody>

                            <!--Iteramos cada elemento de la lista de productos -->
                            <c:forEach var="productos" items="${productos}">
                                <tr>
                                    <td>${productos.getId()}</td>
                                    <td>${productos.getNombre()}</td> 
                                    <td>${productos.getDescripcion()}</td>
                                    <td>${productos.getCantidadInventario()}</td>
                                    <td>${productos.getPrecioDeCompra()}</td> 
                                    <td>${productos.getPrecioDeVenta()}</td>
                                    <td>${productos.getPresentacion()}</td> 
                                    <td>${productos.getIdCategoria()}</td>
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
        </div>
    </div>
</section>

<!-- Modal agregar producto-->
<jsp:include page="/WEB-INF/paginas/agregar/agregarProducto.jsp"/>

