package org.uniquindio.edu.co.poo.banco.controller;

import org.uniquindio.edu.co.poo.banco.model.Banco;
import org.uniquindio.edu.co.poo.banco.model.Transaccion;

import java.util.ArrayList;

public class TransaccionController {
    Banco banco;

    public TransaccionController(Banco banco) {
        this.banco = banco;
    }
    public ArrayList<Transaccion> obtenerListaTransacciones() {
        return banco.getListaTransacciones();
    }

    public boolean registrarTransaccion(Transaccion transaccion) {
        return banco.realizarTransaccion(transaccion);
    }
}
