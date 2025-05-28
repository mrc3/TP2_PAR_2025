package interfaces;

import java.util.List; 
import modelo.Ventas;

public interface InterfazVentaDAO {

List<Ventas> listar();

Ventas obtenerPorId(int id);

boolean agregar(Ventas venta);

boolean editar(Ventas venta);

boolean eliminar(int id);

}
