package com.ejemplo.rentas.fluido;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class BuilderFluidoTest {

    @Test
    void construyeConLosComponentesIndicados() {
        Renta renta = new ConstructorRenta()
                .canonArrendamiento(BigDecimal.valueOf(500))
                .internet(BigDecimal.valueOf(30))
                .construir();

        assertEquals(BigDecimal.valueOf(500), renta.getCanonArrendamiento());
        assertEquals(BigDecimal.valueOf(30), renta.getInternet());
        assertNull(renta.getAgua());
    }

    @Test
    void elOrdenDeLosPasosNoImporta() {
        Renta renta = new ConstructorRenta()
                .parqueadero(BigDecimal.TEN)
                .canonArrendamiento(BigDecimal.ONE)
                .construir();

        assertEquals(BigDecimal.ONE, renta.getCanonArrendamiento());
        assertEquals(BigDecimal.TEN, renta.getParqueadero());
    }

    @Test
    void sinCanonNoSeConstruye() {
        assertThrows(IllegalStateException.class,
                () -> new ConstructorRenta().agua(BigDecimal.ONE).construir());
    }
}
