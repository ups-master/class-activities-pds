package com.ejemplo.rentas.clasico;

import java.math.BigDecimal;

/**
 * Terreno: solo canon (obligatorio) y otros cargos (opcional).
 * Los demás pasos no aplican y se ignoran, así el proceso común sigue siendo el mismo.
 */
public class ConstructorRentaTerreno implements ConstructorRenta {

    private Renta renta = new Renta();

    @Override
    public void agregarCanonArrendamiento(BigDecimal valor) { renta.setCanonArrendamiento(valor); }

    @Override
    public void agregarAlicuota(BigDecimal valor) { }

    @Override
    public void agregarAgua(BigDecimal valor) { }

    @Override
    public void agregarElectricidad(BigDecimal valor) { }

    @Override
    public void agregarInternet(BigDecimal valor) { }

    @Override
    public void agregarParqueadero(BigDecimal valor) { }

    @Override
    public void agregarOtrosCargos(BigDecimal valor) { renta.setOtrosCargos(valor); }

    @Override
    public Renta obtenerRenta() {
        if (renta.getCanonArrendamiento() == null) {
            throw new IllegalStateException("El terreno requiere canon de arrendamiento");
        }
        Renta resultado = renta;
        renta = new Renta();
        return resultado;
    }
}
