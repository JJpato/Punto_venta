
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section id="productos">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="card">
                    <div class="card-header">
                        
                        <h4>Detalles de ventas</h4>
                        
                    </div>
                    <table class="table table-striped">
                        <thead class="thead-dark">
                            <tr>
                                <th>IdVenta</th>
                                <th>IdProducto</th>
                                <th>Cantidad Vendida</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!--Iteramos cada elemento de la lista de productos -->
                            <c:forEach var="detalles" items="${detalles}">
                                <tr>
                                    <td>${detalles.getIdVenta()}</td>
                                    <td>${detalles.getIdProducto()}</td> 
                                    <td>${detalles.getCantidad()}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</section>