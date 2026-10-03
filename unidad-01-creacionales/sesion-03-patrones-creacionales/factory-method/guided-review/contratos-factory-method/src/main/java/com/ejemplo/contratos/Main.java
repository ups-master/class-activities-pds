package com.ejemplo.contratos;

import com.ejemplo.contratos.creador.CreadorContrato;
import com.ejemplo.contratos.creador.CreadorFactura;
import com.ejemplo.contratos.creador.CreadorFijo;
import com.ejemplo.contratos.creador.CreadorTemporal;
import com.ejemplo.contratos.modelo.Contrato;
import java.util.List;

/** Demo: el cliente solo conoce CreadorContrato y Contrato, nunca las clases concretas. */
public class Main {

    public static void main(String[] args) {
        List<CreadorContrato> creadores = List.of(
                new CreadorFijo(2000),
                new CreadorTemporal(1500),
                new CreadorFactura(80, 25));

        for (CreadorContrato creador : creadores) {
            Contrato contrato = creador.crearContrato();
            System.out.printf("%s -> sueldo: %.2f%n",
                    contrato.getClass().getSimpleName(), contrato.calcularSueldo());
        }
    }
}
