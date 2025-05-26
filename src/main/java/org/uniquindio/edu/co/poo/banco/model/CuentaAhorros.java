package org.uniquindio.edu.co.poo.banco.model;

import java.time.LocalDate;

public class CuentaAhorros extends Cuenta{

    private double tasaInteres;
    private int retiros;

    public CuentaAhorros(double tasaInteres, int retiros, LocalDate fechaCreacion, double saldo) {
        super(fechaCreacion, saldo);
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
    public String toString() {
        return "CuentaAhorros{" +
                "tasaInteres=" + tasaInteres +
                ", retiros=" + retiros +
                '}';
    }

    @Override
    public boolean depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            return true;
        }
        return false;
    }
}
