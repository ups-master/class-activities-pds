package com.ejemplo.contratos.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ContratosTest {

    @Test
    void contratoFijoPagaElSalarioMensual() {
        assertEquals(2000.0, new ContratoFijo(2000).calcularSueldo(), 1e-9);
    }

    @Test
    void contratoTemporalAplicaRetencion() {
        assertEquals(1350.0, new ContratoTemporal(1500).calcularSueldo(), 1e-9);
    }

    @Test
    void contratoFacturaMultiplicaHorasPorTarifa() {
        assertEquals(2000.0, new ContratoFactura(80, 25).calcularSueldo(), 1e-9);
    }

    @Test
    void rechazaValoresNegativos() {
        assertThrows(IllegalArgumentException.class, () -> new ContratoFijo(-1));
        assertThrows(IllegalArgumentException.class, () -> new ContratoTemporal(-1));
        assertThrows(IllegalArgumentException.class, () -> new ContratoFactura(-1, 10));
        assertThrows(IllegalArgumentException.class, () -> new ContratoFactura(10, -1));
    }
}
