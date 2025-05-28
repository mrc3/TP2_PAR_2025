package modelo;

import java.util.Date;

public class Ventas {
    private int id;
    private int productoId;
    private int cantidad;
    private Date fecha;

    // Getters
    public int getId() { return id; }
    public int getProductoId() { return productoId; }
    public int getCantidad() { return cantidad; }
    public Date getFecha() { return fecha; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setProductoId(int productoId) { this.productoId = productoId; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
    public void setFecha(Date fecha) { this.fecha = fecha; }
}
