<!-- Modal agregar producto-->
<div class="modal fade" id="agregarProductoModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agregar Producto</h5> 
                <button class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>
            
            <form action="${pageContext.request.contextPath}/Controlador?accion=insertar" method="POST" class="was-validated">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="id">Id</label>
                        <input type="text" class="form-control" name="id" required>
                    </div>
                    <div class="form-group">
                        <label for="nombre">Nombre</label>
                        <input type="text" class="form-control" name="nombre" required>
                    </div>
                    <div class="form-group">
                        <label for="descripcion">Descripcion</label>
                        <input type="text" class="form-control" name="descripcion" required>
                    </div>
                    <div class="form-group">
                        <label for="cantidad">Cantidad</label>
                        <input type="text" class="form-control" name="cantidad" required>
                    </div>
                    <div class="form-group">
                        <label for="pcompra">Precio de Compra</label>
                        <input type="text" class="form-control" name="pcompra" required>
                    </div>
                    <div class="form-group">
                        <label for="pventa">Precio de venta</label>
                        <input type="text" class="form-control" name="pventa" required>
                    </div>
                    <div class="form-group">
                        <label for="presentacion">Presentacion</label>
                        <input type="text" class="form-control" name="presentacion" required>
                    </div>  
                    <div class="form-group">
                        <label for="categoria">Categoria</label>
                        <input type="text" class="form-control" name="categoria" required>
                    </div>                     
                </div>
                <div class="modal-footer">
                    <button class="btn btm-primary bg-info text-white" type="submit">Guardar</button>
                </div>
            </form>
        </div>
    </div>
</div>
