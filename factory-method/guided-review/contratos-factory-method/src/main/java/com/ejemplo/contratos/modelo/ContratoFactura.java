package com.ejemplo.contratos.modelo;

/** Contrato por factura (honorarios): horas trabajadas por tarifa por hora. */
public class ContratoFactura extends Contrato {

    private final double horas;
    private final double tarifaPorHora;

    public ContratoFactura(double horas, double tarifaPorHora) {
        if (horas < 0 || tarifaPorHora < 0) {
            throw new IllegalArgumentException("Las horas y la tarifa no pueden ser negativas");
        }
        this.horas = horas;
        this.tarifaPorHora = tarifaPorHora;
    }

    @Override
    public double calcularSueldo() {
        return horas * tarifaPorHora;
    }
}
