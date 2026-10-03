package com.ejemplo.rentas.clasico;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class BuilderClasicoTest {

    @Test
    void directorUsaElMismoProcesoParaCadaTipo() {
        Renta departamento = new DirectorRenta(new ConstructorRentaDepartamento()).construirRenta();
        Renta terreno = new DirectorRenta(new ConstructorRentaTerreno()).construirRenta();

        assertEquals(BigDecimal.valueOf(40), departamento.getAlicuota());
        assertEquals(BigDecimal.valueOf(30), departamento.getInternet());
        assertEquals(BigDecimal.valueOf(500), terreno.getCanonArrendamiento());
        assertEquals(BigDecimal.valueOf(10), terreno.getOtrosCargos());
        assertNull(terreno.getAlicuota());
        assertNull(terreno.getAgua());
        assertNull(terreno.getParqueadero());
    }

    @Test
    void departamentoExigeAlicuota() {
        ConstructorRenta constructor = new ConstructorRentaDepartamento();
        constructor.agregarCanonArrendamiento(BigDecimal.TEN);
        assertThrows(IllegalStateException.class, constructor::obtenerRenta);
    }

    @Test
    void casaExigeAguaYElectricidad() {
        ConstructorRenta constructor = new ConstructorRentaCasa();
        constructor.agregarCanonArrendamiento(BigDecimal.TEN);
        constructor.agregarAgua(BigDecimal.ONE);
        assertThrows(IllegalStateException.class, constructor::obtenerRenta);
    }

    @Test
    void terrenoSoloExigeCanon() {
        ConstructorRenta constructor = new ConstructorRentaTerreno();
        assertThrows(IllegalStateException.class, constructor::obtenerRenta);
        constructor.agregarCanonArrendamiento(BigDecimal.TEN);
        assertEquals(BigDecimal.TEN, constructor.obtenerRenta().getCanonArrendamiento());
    }

    @Test
    void elConstructorSePuedeReutilizar() {
        ConstructorRenta constructor = new ConstructorRentaTerreno();
        constructor.agregarCanonArrendamiento(BigDecimal.TEN);
        Renta primera = constructor.obtenerRenta();
        assertNotNull(primera);
        assertThrows(IllegalStateException.class, constructor::obtenerRenta);
    }
}
