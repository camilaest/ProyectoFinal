package org.uniquindio.edu.co.poo.banco.model;

import java.time.LocalDate;

public abstract class Cuenta {

    public Cliente cliente;
    public LocalDate fechaCreacion;
    public String codigo;
    public double saldo;
    public Cliente propietario;

    public Cuenta(Cliente cliente, LocalDate fechaCreacion, String codigo, double saldo, Cliente propietario) {
        this.cliente = cliente;
        this.fechaCreacion = fechaCreacion;
        this.codigo = codigo;
        this.saldo = saldo;
        this.propietario = propietario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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

    public Cliente getPropietario() {
        return propietario;
    }

    public void setPropietario(Cliente propietario) {
        this.propietario = propietario;
    }

    public abstract boolean retirar(double monto);
    public abstract void depositar(double monto);
    public abstract double consultarSaldo();
}
