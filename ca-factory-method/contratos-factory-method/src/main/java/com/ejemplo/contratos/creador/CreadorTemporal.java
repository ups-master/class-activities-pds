package com.ejemplo.contratos.creador;

import com.ejemplo.contratos.modelo.Contrato;
import com.ejemplo.contratos.modelo.ContratoTemporal;

public class CreadorTemporal extends CreadorContrato {

    private final double salarioMensual;

    public CreadorTemporal(double salarioMensual) {
        this.salarioMensual = salarioMensual;
    }

    @Override
    public Contrato crearContrato() {
        return new ContratoTemporal(salarioMensual);
    }
}
