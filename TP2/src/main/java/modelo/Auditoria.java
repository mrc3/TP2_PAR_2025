package modelo;

public class Auditoria {
    private int id;
    private String nombre;
    private String descripcion;
    private int unidades;
    private double costo;
    private double precio;
    private String categoria;
    private int idUsuario;
    private String usuario;
    private String accion;
    private String modulo;
    private String fecha;

    public Auditoria() {}

    public Auditoria(String nombre, String descripcion, int unidades, double costo, double precio, String categoria, int idUsuario, String usuario, String accion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.unidades = unidades;
        this.costo = costo;
        this.precio = precio;
        this.categoria = categoria;
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.accion = accion;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public int getUnidades() { return unidades; }
    public void setUnidades(int unidades) { this.unidades = unidades; }

    public double getCosto() { return costo; }
    public void setCosto(double costo) { this.costo = costo; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }

    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }

    public String getAccion() { return accion; }
    public void setAccion(String accion) { this.accion = accion; }

    public String getModulo() { return modulo; }
    public void setModulo(String modulo) { this.modulo = modulo; }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }
}
