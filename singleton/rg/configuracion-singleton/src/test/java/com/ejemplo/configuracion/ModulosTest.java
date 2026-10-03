package com.ejemplo.configuracion;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ModulosTest {

    private final PrintStream salidaOriginal = System.out;
    private ByteArrayOutputStream salida;

    @BeforeEach
    void capturarSalida() {
        salida = new ByteArrayOutputStream();
        System.setOut(new PrintStream(salida));
    }

    @AfterEach
    void restaurar() {
        System.setOut(salidaOriginal);
        ConfiguracionGlobal.obtenerInstancia().establecerParametro("moneda", "USD");
    }

    @Test
    void facturacionYReportesVenElCambioDeMoneda() {
        ConfiguracionGlobal.obtenerInstancia().establecerParametro("moneda", "EUR");

        new ModuloFacturacion().procesar();
        new ModuloReportes().generar();

        String texto = salida.toString();
        assertTrue(texto.contains("Facturación: moneda=EUR"), texto);
        assertTrue(texto.contains("Reportes: empresa=Mi Empresa, moneda=EUR"), texto);
    }

    @Test
    void inventarioMuestraLaEmpresa() {
        new ModuloInventario().procesar();

        assertTrue(salida.toString().contains("Inventario: empresa=Mi Empresa"), salida.toString());
    }
}
