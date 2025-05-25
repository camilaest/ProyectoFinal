package org.uniquindio.edu.co.poo.banco.model;

import java.time.LocalDate;

public class CuentaCorriente extends Cuenta {

    private double sobregiro;
    private double comisionMensual;

    public CuentaCorriente(double sobregiro, double comisionMensual, Cliente cliente, LocalDate fechaCreacion, String codigo, double saldo, Cliente propietario) {
        super(cliente, fechaCreacion, codigo, saldo, propietario);
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
