package org.uniquindio.edu.co.poo.banco.model;

import java.util.ArrayList;

public class Cliente extends Persona{

    private ArrayList<Cuenta> listaCuentas;

    public Cliente( String nombre, String apellidos, String cedula, String email) {
        super(nombre, apellidos, cedula, email);
        this.listaCuentas = new ArrayList<>();
    }

    public ArrayList<Cuenta> getListaCuentas() {
        return listaCuentas;
    }

    public void setListaCuentas(ArrayList<Cuenta> listaCuentas) {
        this.listaCuentas = listaCuentas;
    }

    public void agregarCuenta(Cuenta cuenta) {
        System.out.println("Agregando cuenta"+cuenta.getCodigo());
        listaCuentas.add(cuenta);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "listaCuentas=" + listaCuentas +
                '}';
    }
}
