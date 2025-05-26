package org.uniquindio.edu.co.poo.banco.controller;

import org.uniquindio.edu.co.poo.banco.model.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class DepositoController {
    Banco banco;
    public DepositoController(Banco banco) {
        this.banco = banco;
    }

    public boolean registrarDeposito(Deposito deposito) {

        return banco.realizarDeposito(deposito);

    }

    public ArrayList<Deposito> obtenerListaDeposito() {
        return banco.getListaDepositos();
    }
}
