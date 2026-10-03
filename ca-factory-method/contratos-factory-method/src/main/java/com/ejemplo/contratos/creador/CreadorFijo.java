package com.ejemplo.contratos.creador;

import com.ejemplo.contratos.modelo.Contrato;
import com.ejemplo.contratos.modelo.ContratoFijo;

public class CreadorFijo extends CreadorContrato {

    private final double salarioMensual;

    public CreadorFijo(double salarioMensual) {
        this.salarioMensual = salarioMensual;
    }

    @Override
    public Contrato crearContrato() {
        return new ContratoFijo(salarioMensual);
    }
}
