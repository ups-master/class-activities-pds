package com.ejemplo.configuracion;

public class Main {

    public static void main(String[] args) {
        ModuloFacturacion facturacion = new ModuloFacturacion();
        ModuloInventario inventario = new ModuloInventario();
        ModuloReportes reportes = new ModuloReportes();

        System.out.println("== Configuración inicial ==");
        facturacion.procesar();
        inventario.procesar();
        reportes.generar();

        System.out.println();
        System.out.println("== Se cambia la moneda a EUR en un solo punto ==");
        ConfiguracionGlobal.obtenerInstancia().establecerParametro("moneda", "EUR");
        facturacion.procesar();
        inventario.procesar();
        reportes.generar();
    }
}
