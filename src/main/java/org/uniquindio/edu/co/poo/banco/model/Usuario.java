package org.uniquindio.edu.co.poo.banco.model;

public class Usuario {
    private String nombreUsuario;
    private String contrasenia;
    private String role;

    public Usuario(String nombreUsuario, String contrasenia, String role) {
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.role = role;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombreUsuario='" + nombreUsuario + '\'' +
                ", contrasenia='" + contrasenia + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
