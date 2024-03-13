package DAP;

public interface DepartamentoDAO {
    void agregarDepartamento(int id, String nombre, String clave);
    void listarDepartamentos();
    void actualizarDepartamento(int id, String nombre, String clave);
    void eliminarDepartamento(int id);
}