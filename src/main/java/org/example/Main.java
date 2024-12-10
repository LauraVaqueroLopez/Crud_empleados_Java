package org.example;

import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {
        DAOEmpleado daoEmpleado = new DAOEmpleado();

        DTOEmpleado nuevoEmpleado = new DTOEmpleado("YOLO", 18, 2);
        daoEmpleado.insert(nuevoEmpleado);
        int id= 2;
        DTOEmpleado empleadoEncontrado = daoEmpleado.getById(id);
        if (empleadoEncontrado != null) {
            System.out.println("\nDatos empleado con id "+ id + ": {" + empleadoEncontrado);
        } else {
            System.out.println("Empleado no encontrado.");
        }

        int idActualizar = 1;
        DTOEmpleado empleadoActualizado = new DTOEmpleado("Laura Modificada", 35, 3);
        daoEmpleado.updateEmpleado(idActualizar, empleadoActualizado);

        daoEmpleado.deleteById(28);
//        daoEmpleado.deleteById(26);
//        daoEmpleado.deleteById(27);


    }
}
