package com.ejemplo.configuracion;

public class ModuloReportes {

    public void generar() {
        ConfiguracionGlobal config = ConfiguracionGlobal.obtenerInstancia();
        System.out.println("Reportes: empresa=" + config.obtenerParametro("empresa")
                + ", moneda=" + config.obtenerParametro("moneda"));
    }
}
