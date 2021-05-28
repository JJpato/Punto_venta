
package Modelo;

public class Producto {
    private int id=0;
    private String nombre="";
    private String descripcion="";
    private int cantidadInventario=0;
    private float precioDeCompra=0;
    private float precioDeVenta=0;
    private String presentacion="";
    private int idCategoria=0;

    public Producto() {

    }
    public Producto(int id, String nombre, String descripcion, int cantidadInventario, float precioDeCompra, float precioDeVenta, String presentacion, int idCategoria) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidadInventario = cantidadInventario;
        this.precioDeCompra = precioDeCompra;
        this.precioDeVenta = precioDeVenta;
        this.presentacion = presentacion;
        this.idCategoria = idCategoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidadInventario() {
        return cantidadInventario;
    }

    public void setCantidadInventario(int cantidadInventario) {
        this.cantidadInventario = cantidadInventario;
    }

    public float getPrecioDeCompra() {
        return precioDeCompra;
    }

    public void setPrecioDeCompra(float precioDeCompra) {
        this.precioDeCompra = precioDeCompra;
    }

    public float getPrecioDeVenta() {
        return precioDeVenta;
    }

    public void setPrecioDeVenta(float precioDeVenta) {
        this.precioDeVenta = precioDeVenta;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
}
