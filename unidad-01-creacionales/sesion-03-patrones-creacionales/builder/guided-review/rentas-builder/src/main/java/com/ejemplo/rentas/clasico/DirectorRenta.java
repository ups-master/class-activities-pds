package com.ejemplo.rentas.clasico;

import java.math.BigDecimal;

/**
 * Director: define el proceso común (siempre los mismos pasos, en el mismo orden).
 * Cada constructor concreto decide qué pasos aplican a su tipo de propiedad.
 */
public class DirectorRenta {

    private final ConstructorRenta constructor;

    public DirectorRenta(ConstructorRenta constructor) {
        this.constructor = constructor;
    }

    public Renta construirRenta() {
        constructor.agregarCanonArrendamiento(BigDecimal.valueOf(500));
        constructor.agregarAlicuota(BigDecimal.valueOf(40));
        constructor.agregarAgua(BigDecimal.valueOf(15));
        constructor.agregarElectricidad(BigDecimal.valueOf(25));
        constructor.agregarInternet(BigDecimal.valueOf(30));
        constructor.agregarParqueadero(BigDecimal.valueOf(20));
        constructor.agregarOtrosCargos(BigDecimal.valueOf(10));
        return constructor.obtenerRenta();
    }
}
