package com.ejemplo.contratos.creador;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.ejemplo.contratos.modelo.Contrato;
import com.ejemplo.contratos.modelo.ContratoFactura;
import com.ejemplo.contratos.modelo.ContratoFijo;
import com.ejemplo.contratos.modelo.ContratoTemporal;
import org.junit.jupiter.api.Test;

class CreadoresTest {

    @Test
    void creadorFijoDevuelveContratoFijo() {
        Contrato c = new CreadorFijo(2000).crearContrato();
        assertInstanceOf(ContratoFijo.class, c);
        assertEquals(2000.0, c.calcularSueldo(), 1e-9);
    }

    @Test
    void creadorTemporalDevuelveContratoTemporal() {
        Contrato c = new CreadorTemporal(1500).crearContrato();
        assertInstanceOf(ContratoTemporal.class, c);
        assertEquals(1350.0, c.calcularSueldo(), 1e-9);
    }

    @Test
    void creadorFacturaDevuelveContratoFactura() {
        Contrato c = new CreadorFactura(80, 25).crearContrato();
        assertInstanceOf(ContratoFactura.class, c);
        assertEquals(2000.0, c.calcularSueldo(), 1e-9);
    }

    @Test
    void cadaLlamadaCreaUnaInstanciaNueva() {
        CreadorContrato creador = new CreadorFijo(1000);
        assertNotSame(creador.crearContrato(), creador.crearContrato());
    }

    @Test
    void elClienteTrabajaPolimorficamenteConCualquierCreador() {
        CreadorContrato[] creadores = {
            new CreadorFijo(100), new CreadorTemporal(100), new CreadorFactura(1, 100)
        };
        double[] esperado = {100.0, 90.0, 100.0};
        for (int i = 0; i < creadores.length; i++) {
            assertEquals(esperado[i], creadores[i].crearContrato().calcularSueldo(), 1e-9);
        }
    }

    @Test
    void laValidacionSeDisparaAlCrearElContrato() {
        assertThrows(IllegalArgumentException.class, () -> new CreadorFijo(-5).crearContrato());
    }
}
