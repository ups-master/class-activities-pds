package com.ejemplo.configuracion;

public class ModuloInventario {

    public void procesar() {
        ConfiguracionGlobal config = ConfiguracionGlobal.obtenerInstancia();
        System.out.println("Inventario: empresa=" + config.obtenerParametro("empresa"));
    }
}
