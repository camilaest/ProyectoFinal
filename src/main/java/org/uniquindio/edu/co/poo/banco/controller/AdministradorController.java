package org.uniquindio.edu.co.poo.banco.controller;

import org.uniquindio.edu.co.poo.banco.model.Banco;
import org.uniquindio.edu.co.poo.banco.model.Cajero;
import org.uniquindio.edu.co.poo.banco.model.Cliente;
import org.uniquindio.edu.co.poo.banco.model.Usuario;

import java.util.ArrayList;

public class AdministradorController {

    Banco banco;

    public AdministradorController(Banco banco) {
        this.banco = banco;
    }

    public boolean registrarCajero(Cajero cajero) {
        System.out.println("Cliente registrado con exito"+ cajero);

        return banco.registrarCajero(cajero);

    }

    public void registrarUsuario(Usuario usuario) {
        banco.registrarUsuario(usuario);
        System.out.println("Usuario registrado con exito"+ usuario);
    }

    public ArrayList<Cajero> obtenerListaCajeros() {
        return banco.getListaCajeros();
    }



    public boolean eliminarCajero(String cedula) {
        return banco.eliminarCajero(cedula);
    }

    public boolean actualizarCajero(String cedula, Cajero cajero) {
        return banco.actualizarCajero(cedula, cajero);
    }
}
