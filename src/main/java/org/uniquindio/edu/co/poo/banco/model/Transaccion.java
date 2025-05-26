package org.uniquindio.edu.co.poo.banco.model;

import java.time.LocalDateTime;

public class Transaccion extends Movimiento {

    private Cuenta cuentaOrigen;
    private Cuenta cuentaDestino;


    public Transaccion(LocalDateTime fecha, Cuenta cuentaOrigen, Cuenta cuentaDestino, TipoMovimiento tipoTransaccion) {
        super( fecha, tipoTransaccion);
        this.cuentaOrigen = cuentaOrigen;
        this.cuentaDestino = cuentaDestino;

    }


    public Cuenta getCuentaOrigen() {
        return cuentaOrigen;
    }

    public void setCuentaOrigen(Cuenta cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen;
    }

    public Cuenta getCuentaDestino() {
        return cuentaDestino;
    }

    public void setCuentaDestino(Cuenta cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }

    @Override
    public String toString() {
        return "Transaccion{" +
                "cuentaOrigen=" + cuentaOrigen +
                ", cuentaDestino=" + cuentaDestino +
                '}';
    }

    /*public static String transferirDinero(Cuenta cuentaOrigen, Cuenta cuentaDestino, double monto) {
        if (monto <= 0) {
            return "El monto debe ser mayor que cero.";
        }

        if (cuentaOrigen.realizarRetiro(monto)) {
            cuentaDestino.realizarDeposito(monto);
            return "Transferencia exitosa de " + monto + " desde la cuenta " +
                    cuentaOrigen.getCodigo() + " a la cuenta " + cuentaDestino.getCodigo();
        } else {
            return "Fondos insuficientes en la cuenta origen.";
        }
    }*/
}
