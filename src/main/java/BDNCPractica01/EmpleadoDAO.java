package BDNCPractica01;

public interface EmpleadoDAO {
    void agregarEmpleado(int id, String nombre, String direccion, String telefono, int idDepartamento);
    void listarEmpleados();
    void actualizarEmpleado(int id, String nombre, String direccion, String telefono, int idDepartamento);
    void eliminarEmpleado(int id);
}
