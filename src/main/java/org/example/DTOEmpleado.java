package org.example;

public class DTOEmpleado {

    private String nombre;
    private int edad;
    private int dpto_id;
    public DTOEmpleado(String nombre, int edad, int dpto_id) {
        this.nombre = nombre;
        this.edad = edad;
        this.dpto_id = dpto_id;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }


    public int getDpto_id() {
        return dpto_id;
    }

    public void setDpto_id(int dpto_id) {
        this.dpto_id = dpto_id;
    }

    @Override
    public String toString() {
        return "\nNombre:" + nombre + "\n" +
                "Edad:" + edad + "\n" +
                "Departamento:" + dpto_id + "\n" + "}";
    }
}
