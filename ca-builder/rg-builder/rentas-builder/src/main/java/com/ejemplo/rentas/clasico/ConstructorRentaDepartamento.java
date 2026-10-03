package com.ejemplo.rentas.clasico;

import java.math.BigDecimal;

/** Departamento: canon y alícuota obligatorios; el resto es opcional. */
public class ConstructorRentaDepartamento implements ConstructorRenta {

    private Renta renta = new Renta();

    @Override
    public void agregarCanonArrendamiento(BigDecimal valor) { renta.setCanonArrendamiento(valor); }

    @Override
    public void agregarAlicuota(BigDecimal valor) { renta.setAlicuota(valor); }

    @Override
    public void agregarAgua(BigDecimal valor) { renta.setAgua(valor); }

    @Override
    public void agregarElectricidad(BigDecimal valor) { renta.setElectricidad(valor); }

    @Override
    public void agregarInternet(BigDecimal valor) { renta.setInternet(valor); }

    @Override
    public void agregarParqueadero(BigDecimal valor) { renta.setParqueadero(valor); }

    @Override
    public void agregarOtrosCargos(BigDecimal valor) { renta.setOtrosCargos(valor); }

    @Override
    public Renta obtenerRenta() {
        if (renta.getCanonArrendamiento() == null || renta.getAlicuota() == null) {
            throw new IllegalStateException("El departamento requiere canon de arrendamiento y alícuota");
        }
        Renta resultado = renta;
        renta = new Renta();
        return resultado;
    }
}
