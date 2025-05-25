package org.uniquindio.edu.co.poo.banco.model;

import java.time.LocalDate;

public class CuentaAhorros extends Cuenta{

    private double tasaInteres;
    private int retiros;

    public CuentaAhorros(double tasaInteres, int retiros, Cliente cliente, LocalDate fechaCreacion, String codigo, double saldo, Cliente propietario) {
        super(cliente, fechaCreacion, codigo, saldo, propietario);
        this.tasaInteres = tasaInteres;
        this.retiros = retiros;
    }

    public double getTasaInteres() {
        return tasaInteres;
    }

    public void setTasaInteres(double tasaInteres) {
        this.tasaInteres = tasaInteres;
    }

    public int getRetiros() {
        return retiros;
    }

    public void setRetiros(int retiros) {
        this.retiros = retiros;
    }


    @Override
    public boolean retirar(double monto) {
        if (saldo >= monto) {
            saldo -= monto;
            return true;
        }
        return false;

    }

    @Override
    public void depositar(double monto) {
        saldo += monto;
    }

    @Override
    public double consultarSaldo() {
        return 0;
    }
}
