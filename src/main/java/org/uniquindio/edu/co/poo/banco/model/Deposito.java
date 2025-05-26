package org.uniquindio.edu.co.poo.banco.model;

import java.time.LocalDateTime;

public class Deposito extends Movimiento{

    private String codigoCuentaADepositar;
    private double saldoADepositar;

    public Deposito(String codigoCuentaADepositar, double saldoADepositar, LocalDateTime fecha, TipoMovimiento tipoMovimiento) {
        super(fecha, tipoMovimiento);
        this.codigoCuentaADepositar = codigoCuentaADepositar;
        this.saldoADepositar = saldoADepositar;
    }


    public double getSaldoADepositar() {
        return saldoADepositar;
    }

    public void setSaldoADepositar(double saldoADepositar) {
        this.saldoADepositar = saldoADepositar;
    }

    public String getCodigoCuentaADepositar() {
        return codigoCuentaADepositar;
    }

    public void setCodigoCuentaADepositar(String codigoCuenta) {
        this.codigoCuentaADepositar = codigoCuenta;
    }



    @Override
    public String toString() {
        return "Deposito{" +
                "codigoCuentaADepositar='" + codigoCuentaADepositar + '\'' +
                ", saldoADepositar=" + saldoADepositar +
                '}';
    }
}
