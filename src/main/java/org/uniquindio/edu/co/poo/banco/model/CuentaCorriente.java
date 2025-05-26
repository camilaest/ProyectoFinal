package org.uniquindio.edu.co.poo.banco.model;

import java.time.LocalDate;

public class CuentaCorriente extends Cuenta {

    private double sobregiro;
    private double comisionMensual;

    public CuentaCorriente(double sobregiro, double comisionMensual, LocalDate fechaCreacion, double saldo) {
        super( fechaCreacion, saldo);
        this.sobregiro = sobregiro;
        this.comisionMensual = comisionMensual;
    }

    public double getSobregiro() {
        return sobregiro;
    }

    public void setSobregiro(double sobregiro) {
        this.sobregiro = sobregiro;
    }

    public double getComisionMensual() {
        return comisionMensual;
    }

    public void setComisionMensual(double comisionMensual) {
        this.comisionMensual = comisionMensual;
    }

    @Override
    public String toString() {
        return "CuentaCorriente{" +
                "sobregiro=" + sobregiro +
                ", comisionMensual=" + comisionMensual +
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
