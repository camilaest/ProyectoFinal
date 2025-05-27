package org.uniquindio.edu.co.poo.banco.model;

import java.time.LocalDateTime;

public class Retiro extends Movimiento{

    private String codigoCuenta;
    private double saldoRetiro;

    public Retiro(String codigoCuenta, LocalDateTime fecha, TipoMovimiento tipoMovimiento, double saldoRetiro) {
        super(fecha, tipoMovimiento);
        this.codigoCuenta = codigoCuenta;
        this.saldoRetiro = saldoRetiro;
    }

    public String getCodigoCuenta() {
        return codigoCuenta;
    }

    public void setCodigoCuenta(String codigoCuenta) {
        this.codigoCuenta = codigoCuenta;
    }

    public double getSaldoRetiro() {
        return saldoRetiro;
    }
    public void setSaldoRetiro(double saldoRetiro) {
        this.saldoRetiro = saldoRetiro;
    }

    @Override
    public String toString() {
        return "Retiro{" +
                "codigoCuenta='" + codigoCuenta + '\'' +
                '}';
    }
}
