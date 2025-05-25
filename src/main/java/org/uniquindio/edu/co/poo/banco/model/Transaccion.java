package org.uniquindio.edu.co.poo.banco.model;

import java.time.LocalDateTime;

public class Transaccion {
    private String id;
    private LocalDateTime fecha;
    private double monto;
    private Cuenta cuentaOrigen;
    private Cuenta cuentaDestino;
    private TipoTransaccion tipoTransaccion;

    public Transaccion(String id, LocalDateTime fecha, double monto, Cuenta cuentaOrigen, Cuenta cuentaDestino, TipoTransaccion tipoTransaccion) {
        this.id = id;
        this.fecha = fecha;
        this.monto = monto;
        this.cuentaOrigen = cuentaOrigen;
        this.cuentaDestino = cuentaDestino;
        this.tipoTransaccion = tipoTransaccion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
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

    public TipoTransaccion getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(TipoTransaccion tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public static String transferirDinero(Cuenta cuentaOrigen, Cuenta cuentaDestino, double monto) {
        if (monto <= 0) {
            return "El monto debe ser mayor que cero.";
        }

        if (cuentaOrigen.retirar(monto)) {
            cuentaDestino.depositar(monto);
            return "Transferencia exitosa de " + monto + " desde la cuenta " +
                    cuentaOrigen.getCodigo() + " a la cuenta " + cuentaDestino.getCodigo();
        } else {
            return "Fondos insuficientes en la cuenta origen.";
        }
    }
}
