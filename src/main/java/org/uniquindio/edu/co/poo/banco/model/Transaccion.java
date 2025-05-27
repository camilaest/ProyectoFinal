package org.uniquindio.edu.co.poo.banco.model;

import java.time.LocalDateTime;

public class Transaccion extends Movimiento {

    private String cuentaOrigen;
    private String cuentaDestino;
    private double saldoADepositar;


    public Transaccion(LocalDateTime fecha, String cuentaOrigen, String cuentaDestino, TipoMovimiento tipoTransaccion, double saldoADepositar) {
        super( fecha, tipoTransaccion);
        this.cuentaOrigen = cuentaOrigen;
        this.cuentaDestino = cuentaDestino;
        this.saldoADepositar = saldoADepositar;

    }


    public double getSaldoADepositar() {
        return saldoADepositar;
    }

    public void setSaldoADepositar(double saldoADepositar) {
        this.saldoADepositar = saldoADepositar;
    }

    public String getCuentaOrigen() {
        return cuentaOrigen;
    }

    public void setCuentaOrigen(String  cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen;
    }

    public String getCuentaDestino() {
        return cuentaDestino;
    }

    public void setCuentaDestino(String cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }

    @Override
    public String toString() {
        return "Transaccion{" +
                "cuentaOrigen=" + cuentaOrigen +
                ", cuentaDestino=" + cuentaDestino +
                '}';
    }


}
