package org.uniquindio.edu.co.poo.banco.model;

import java.util.ArrayList;

public class Cliente extends Persona{

    private ArrayList<Cuenta> listaCuentas;

    public Cliente( String nombre, String apellidos, String cedula, String email) {
        super(nombre, apellidos, cedula, email);
        this.listaCuentas = listaCuentas;
    }


}
