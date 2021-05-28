package Modelo;

public class Venta {

    private int id;
    private double ingreso;
    private double total;
    private int id_usuario;


    public Venta(int id, double ingreso, double total, int id_usuario) {
        this.id = id;
        this.ingreso = ingreso;
        this.total = total;
        this.id_usuario = id_usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getIngreso() {
        return ingreso;
    }

    public void setIngreso(double ingreso) {
        this.ingreso = ingreso;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

}
