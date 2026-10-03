package com.ejemplo.contratos.modelo;

/** Contrato indefinido: el sueldo es el salario mensual pactado. */
public class ContratoFijo extends Contrato {

    private final double salarioMensual;

    public ContratoFijo(double salarioMensual) {
        if (salarioMensual < 0) {
            throw new IllegalArgumentException("El salario mensual no puede ser negativo");
        }
        this.salarioMensual = salarioMensual;
    }

    @Override
    public double calcularSueldo() {
        return salarioMensual;
    }
}
