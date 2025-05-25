package org.uniquindio.edu.co.poo.banco.model;

import java.time.LocalDate;

public class CuentaEmpresarial extends Cuenta {

    private double limiteTransferencia;
    private String nombreEmpresa;

    public CuentaEmpresarial(double limiteTransferencia, String nombreEmpresa, Cliente cliente, LocalDate fechaCreacion, String codigo, double saldo, Cliente propietario) {
        super(cliente, fechaCreacion, codigo, saldo, propietario);
        this.limiteTransferencia = limiteTransferencia;
        this.nombreEmpresa = nombreEmpresa;
    }

    public double getLimiteTransferencia() {
        return limiteTransferencia;
    }

    public void setLimiteTransferencia(double limiteTransferencia) {
        this.limiteTransferencia = limiteTransferencia;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
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
