package com.ejemplo.rentas.sinpatron;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RentaSinPatronTest {

    @Test
    void permiteCombinacionesPocoClaras() {
        BigDecimal cien = BigDecimal.valueOf(100);
        // Nada impide poner el valor en el parámetro equivocado ni dejar todo en null.
        Renta renta = new Renta(cien, null, null, null, null, null, null);
        assertTrue(renta.toString().contains("canonArrendamiento=100"));
    }
}
