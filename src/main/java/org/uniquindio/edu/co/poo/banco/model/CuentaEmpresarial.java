package org.uniquindio.edu.co.poo.banco.model;

import java.time.LocalDate;

public class CuentaEmpresarial extends Cuenta {

    private double limiteTransferencia;
    private String nombreEmpresa;

    public CuentaEmpresarial(double limiteTransferencia, String nombreEmpresa,  LocalDate fechaCreacion, double saldo) {
        super( fechaCreacion, saldo);
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
    public String toString() {
        return "CuentaEmpresarial{" +
                "limiteTransferencia=" + limiteTransferencia +
                ", nombreEmpresa='" + nombreEmpresa + '\'' +
                '}';
    }

    @Override
    public boolean depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            return true;
        }
        return false;
    }
}
