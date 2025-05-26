package org.uniquindio.edu.co.poo.banco.model;

import java.time.LocalDateTime;

public class Retiro extends Movimiento{

    private String codigoCuenta;

    public Retiro(String codigoCuenta, LocalDateTime fecha, TipoMovimiento tipoMovimiento) {
        super(fecha, tipoMovimiento);
        this.codigoCuenta = codigoCuenta;
    }

    public String getCodigoCuenta() {
        return codigoCuenta;
    }

    public void setCodigoCuenta(String codigoCuenta) {
        this.codigoCuenta = codigoCuenta;
    }

    @Override
    public String toString() {
        return "Retiro{" +
                "codigoCuenta='" + codigoCuenta + '\'' +
                '}';
    }
}
