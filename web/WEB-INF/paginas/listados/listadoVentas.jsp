
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section id="ventas">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="card">
                    <div class="card-header">
                        <h4>Listado de Ventas <jsp:include page="/WEB-INF/paginas/botones_modal/boton_agregar_venta.jsp"/></h4>
                    </div>
                    <table class="table table-striped">
                        <thead class="thead-dark">
                            <tr>
                                <th>#</th>
                                <th>Ingreso</th>
                                <th>Total</th>
                                <th>Vendedor</th>               
                            </tr>
                        </thead>
                        <tbody>

                            <!--Iteramos cada elemento de la lista de productos -->
                            <c:forEach var="ventas" items="${ventas}">
                                <tr>
                                    <td>${ventas.getId()}</td>
                                    <td>${ventas.getIngreso()}</td> 
                                    <td>${ventas.getTotal()}</td>
                                    <td>${ventas.getId_usuario()}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>


        </div>
    </div>
</section>

<!-- Modal agregar venta-->
<jsp:include page="/WEB-INF/paginas/agregar/agregarVenta.jsp"/>