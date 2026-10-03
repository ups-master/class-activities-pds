package com.ejemplo.contratos.creador;

import com.ejemplo.contratos.modelo.Contrato;
import com.ejemplo.contratos.modelo.ContratoFactura;

public class CreadorFactura extends CreadorContrato {

    private final double horas;
    private final double tarifaPorHora;

    public CreadorFactura(double horas, double tarifaPorHora) {
        this.horas = horas;
        this.tarifaPorHora = tarifaPorHora;
    }

    @Override
    public Contrato crearContrato() {
        return new ContratoFactura(horas, tarifaPorHora);
    }
}
