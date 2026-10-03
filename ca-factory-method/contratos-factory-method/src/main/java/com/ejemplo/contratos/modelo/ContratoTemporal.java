package com.ejemplo.contratos.modelo;

/** Contrato temporal: salario mensual menos un porcentaje de retención (sin beneficios). */
public class ContratoTemporal extends Contrato {

    public static final double RETENCION = 0.10;

    private final double salarioMensual;

    public ContratoTemporal(double salarioMensual) {
        if (salarioMensual < 0) {
            throw new IllegalArgumentException("El salario mensual no puede ser negativo");
        }
        this.salarioMensual = salarioMensual;
    }

    @Override
    public double calcularSueldo() {
        return salarioMensual * (1 - RETENCION);
    }
}
