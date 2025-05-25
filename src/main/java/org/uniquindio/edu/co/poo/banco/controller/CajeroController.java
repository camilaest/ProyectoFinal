package org.uniquindio.edu.co.poo.banco.controller;

import org.uniquindio.edu.co.poo.banco.model.Banco;
import org.uniquindio.edu.co.poo.banco.model.Cliente;
import org.uniquindio.edu.co.poo.banco.model.Usuario;

import java.util.ArrayList;
import java.util.Collection;

public class CajeroController {
    Banco banco;

    public CajeroController(Banco banco) {
        this.banco = banco;
    }

    public boolean registrarCliente(Cliente cliente) {
        System.out.println("Cliente registrado con exito"+ cliente);

        return banco.registrarCliente(cliente);

    }

    public void registrarUsuario(Usuario usuario) {
        banco.registrarUsuario(usuario);
        System.out.println("Usuario registrado con exito"+ usuario);
    }

    public ArrayList<Cliente> obtenerListaClientes() {
        return banco.getListaClientes();
    }

    public boolean eliminarCliente(String cedula) {
        return banco.eliminarCliente(cedula);
    }

    public boolean actualizarCliente(String cedula, Cliente cliente) {
        return banco.actualizarCliente(cedula, cliente);
    }


}
