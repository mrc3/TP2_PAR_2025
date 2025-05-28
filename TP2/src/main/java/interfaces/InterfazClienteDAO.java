
package interfaces;

import java.util.List;
import modelo.Cliente;

public interface InterfazClienteDAO {
    public List<Cliente> listar();
    public Cliente obtenerPorId(int id);
    public boolean agregar(Cliente c);
    public boolean editar(Cliente c);
    public boolean eliminar(int id);
}
