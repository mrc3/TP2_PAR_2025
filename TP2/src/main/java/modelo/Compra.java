package modelo;

import java.util.Date;

public class Compra {
    private int id;
    private String producto;
    private int cantidad;
    private double precioUnitario;
    private Date fecha;

    // Getters
    public int getId() {
        return id;
    }

    public String getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public Date getFecha() {
        return fecha;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
