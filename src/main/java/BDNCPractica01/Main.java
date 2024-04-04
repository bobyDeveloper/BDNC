package BDNCPractica01;

public class Main {
    
    public static void main(String[] args) {
        Empleado empleadoDAO = Empleado.getInstance();
        Departamento departamentoDAO = Departamento.getInstance();

        try {
            // Agregar un departamento
            //departamentoDAO.agregarDepartamento(2, "Pruebas", "Test");

            // Actualizar un departamento
            //departamentoDAO.actualizarDepartamento(1, "Pruebas Actualizadas", "PRB");

            // Eliminar un departamento
             //departamentoDAO.eliminarDepartamento(0);

            // Listar todos los departamentos
            departamentoDAO.listarDepartamentos();

            // Agregar un empleado
            //empleadoDAO.agregarEmpleado(1, "Adsoftsito", "Mendoza", "2721276929", 1);

            // Actualizar un empleado
            //empleadoDAO.actualizarEmpleado(1, "Juan", "Perez Actualizado", "JP01", 1);

            // Eliminar un empleado
            // empleadoDAO.eliminarEmpleado(1);

            // Listar todos los empleados
            //empleadoDAO.listarEmpleados();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}