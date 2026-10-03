package com.ejemplo.rentas.clasico;

import java.math.BigDecimal;

/** Builder: declara los pasos para construir una renta. */
public interface ConstructorRenta {

    void agregarCanonArrendamiento(BigDecimal valor);

    void agregarAlicuota(BigDecimal valor);

    void agregarAgua(BigDecimal valor);

    void agregarElectricidad(BigDecimal valor);

    void agregarInternet(BigDecimal valor);

    void agregarParqueadero(BigDecimal valor);

    void agregarOtrosCargos(BigDecimal valor);

    /** Valida los componentes obligatorios del tipo y entrega la renta. */
    Renta obtenerRenta();
}
