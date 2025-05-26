package org.uniquindio.edu.co.poo.banco.model;

import java.time.LocalDateTime;

public class Movimiento {

    private String id;
    private LocalDateTime fecha;
    private TipoMovimiento tipoTransaccion;

    public Movimiento(LocalDateTime fecha, TipoMovimiento tipoTransaccion) {
        this.id = java.util.UUID.randomUUID().toString();
        this.fecha = fecha;

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




    public TipoMovimiento getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(TipoMovimiento tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    @Override
    public String toString() {
        return "Movimiento{" +
                "id='" + id + '\'' +
                ", fecha=" + fecha +
                ", tipoTransaccion=" + tipoTransaccion +
                '}';
    }
}
