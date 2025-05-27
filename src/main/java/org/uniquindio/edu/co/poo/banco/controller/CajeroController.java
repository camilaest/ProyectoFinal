package org.uniquindio.edu.co.poo.banco.controller;

import org.uniquindio.edu.co.poo.banco.model.*;

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
    /*
    public boolean depositarEntreCuentas(String codigoOrigen, String codigoDestino, double monto){
        boolean exito = banco.depositarEntreCuentas(codigoOrigen, codigoDestino, monto);

        // Luego se imprime el resultado según si fue exitosa o no
        if (exito) {
            System.out.println("✅ Se hizo la transacción correctamente.");
        } else {
            System.out.println("❌ No se pudo realizar la transacción.");
        }

        return exito;

    }*/



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

    public boolean registrarCuenta(String tipoCuenta) {
        return banco.registrarCuenta(tipoCuenta);
    }


    public ArrayList<Deposito> obtenerListaDeposito() {
        return banco.getListaDepositos();
    }

    public ArrayList<Retiro> obtenerListaRetiros() {
        return banco.getListaRetiros();
    }
}
