package com.ejemplo.rentas.clasico;

import java.math.BigDecimal;

/** Casa: canon, agua y electricidad obligatorios; el resto es opcional. */
public class ConstructorRentaCasa implements ConstructorRenta {

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
        if (renta.getCanonArrendamiento() == null || renta.getAgua() == null
                || renta.getElectricidad() == null) {
            throw new IllegalStateException("La casa requiere canon de arrendamiento, agua y electricidad");
        }
        Renta resultado = renta;
        renta = new Renta();
        return resultado;
    }
}
