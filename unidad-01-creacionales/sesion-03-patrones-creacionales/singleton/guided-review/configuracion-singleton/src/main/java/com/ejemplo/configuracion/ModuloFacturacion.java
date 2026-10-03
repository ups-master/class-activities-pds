package com.ejemplo.configuracion;

public class ModuloFacturacion {

    public void procesar() {
        ConfiguracionGlobal config = ConfiguracionGlobal.obtenerInstancia();
        System.out.println("Facturación: moneda=" + config.obtenerParametro("moneda")
                + ", iva=" + config.obtenerParametro("iva"));
    }
}
