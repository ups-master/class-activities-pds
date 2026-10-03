package com.ejemplo.configuracion;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConfiguracionGlobal {

    private static ConfiguracionGlobal instancia;

    private final Map<String, String> parametros = new ConcurrentHashMap<>();

    private ConfiguracionGlobal() {
        parametros.put("moneda", "USD");
        parametros.put("iva", "0.15");
        parametros.put("empresa", "Mi Empresa");
    }

    public static synchronized ConfiguracionGlobal obtenerInstancia() {
        if (instancia == null) {
            instancia = new ConfiguracionGlobal();
        }
        return instancia;
    }

    public String obtenerParametro(String clave) {
        return parametros.get(clave);
    }

    public void establecerParametro(String clave, String valor) {
        parametros.put(clave, valor);
    }
}
