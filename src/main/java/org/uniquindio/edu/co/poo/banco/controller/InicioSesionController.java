package org.uniquindio.edu.co.poo.banco.controller;

import org.uniquindio.edu.co.poo.banco.model.Banco;
import org.uniquindio.edu.co.poo.banco.model.Usuario;

public class InicioSesionController {
    Banco banco;

    public InicioSesionController(Banco banco) {
        this.banco = banco;
    }

    // Metodo que verifica el inicio de sesion
    public boolean iniciarSesion(String usuario, String contrasena) {
        return banco.verificarInicioSesionUsuario(usuario, contrasena);
    }

    public String buscarRoleUsuario(String usuario) {
        return banco.buscarRoleUsuario(usuario);
    }


}
