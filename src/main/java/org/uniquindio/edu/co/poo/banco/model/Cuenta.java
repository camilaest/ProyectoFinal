package org.uniquindio.edu.co.poo.banco.model;

import java.time.LocalDate;
import java.util.UUID;

public abstract class Cuenta {

    public LocalDate fechaCreacion;
    public String codigo;
    public double saldo;


    public Cuenta(LocalDate fechaCreacion, double saldo) {

        this.fechaCreacion = fechaCreacion;
        this.saldo = saldo;
        this.codigo = java.util.UUID.randomUUID().toString();
    }



    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public abstract boolean depositar(double monto);

    @Override
    public String toString() {
        return "Cuenta{" +
                "fechaCreacion=" + fechaCreacion +
                ", codigo='" + codigo + '\'' +
                ", saldo=" + saldo +
                '}';
    }

    public abstract boolean retirar(double saldoRetiro);


}
