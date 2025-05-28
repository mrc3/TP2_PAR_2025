package modelo;

public class Inventario {
    private String id;
    private String nombre;
    private String stock;

    public Inventario() {}
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getStock() { return stock; }
    public void setStock(String stock) { this.stock = stock; }
}
