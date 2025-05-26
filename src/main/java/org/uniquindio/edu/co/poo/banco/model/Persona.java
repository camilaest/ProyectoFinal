package org.uniquindio.edu.co.poo.banco.model;

public abstract class Persona {

    private String nombre;
    private String apellidos;
    private String cedula;
    private String email;

    public Persona(String nombre, String apellidos, String cedula, String email) {
        this.nombre= nombre;
        this.apellidos= apellidos;
        this.cedula = cedula;
        this.email=email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", cedula='" + cedula + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
