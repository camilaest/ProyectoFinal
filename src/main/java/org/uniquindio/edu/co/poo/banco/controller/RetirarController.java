package org.uniquindio.edu.co.poo.banco.controller;

import org.uniquindio.edu.co.poo.banco.model.Banco;
import org.uniquindio.edu.co.poo.banco.model.Retiro;

import java.util.ArrayList;

public class RetirarController {
    Banco banco;
    public RetirarController(Banco banco) {
        this.banco = banco;
    }

    public boolean registrarRetiro(Retiro retiro) {
        return banco.realizarRetiro(retiro);
    }

    public ArrayList<Retiro> obtenerListaRetiro() {
        return banco.getListaRetiros();
    }
}
