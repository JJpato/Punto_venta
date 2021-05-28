<!-- Modal agregar venta-->
<div class="modal fade" id="agregarVentaModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agregar Venta</h5> 
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
                        <label for="ingreso">Ingreso</label>
                        <input type="text" class="form-control" name="ingreso" required>
                    </div>
                    <div class="form-group">
                        <label for="total">Total</label>
                        <input type="text" class="form-control" name="total" required>
                    </div>      
                    <div class="form-group">
                        <label for="idusuario">Usuario</label>
                        <input type="text" class="form-control" name="idusuario" required>
                    </div> 
                </div>
                <div class="modal-footer">
                    <button class="btn btm-primary bg-info text-white" type="submit">Guardar</button>
                </div>
            </form>
        </div>
    </div>
</div>
