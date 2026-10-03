package com.ejemplo.rentas;

import com.ejemplo.rentas.clasico.ConstructorRentaCasa;
import com.ejemplo.rentas.clasico.ConstructorRentaDepartamento;
import com.ejemplo.rentas.clasico.ConstructorRentaTerreno;
import com.ejemplo.rentas.clasico.DirectorRenta;
import com.ejemplo.rentas.fluido.ConstructorRenta;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        System.out.println("== Sin patrón ==");
        // ¿Cuál es la alícuota y cuál el agua? ¿Qué significa cada null?
        System.out.println(new com.ejemplo.rentas.sinpatron.Renta(
                BigDecimal.valueOf(500), BigDecimal.valueOf(40), null, null,
                BigDecimal.valueOf(30), null, null));

        System.out.println("\n== Builder clásico (mismo proceso, distinta configuración) ==");
        System.out.println("Departamento: " + new DirectorRenta(new ConstructorRentaDepartamento()).construirRenta());
        System.out.println("Casa:         " + new DirectorRenta(new ConstructorRentaCasa()).construirRenta());
        System.out.println("Terreno:      " + new DirectorRenta(new ConstructorRentaTerreno()).construirRenta());

        System.out.println("\n== Builder fluido ==");
        System.out.println(new ConstructorRenta()
                .canonArrendamiento(BigDecimal.valueOf(500))
                .alicuota(BigDecimal.valueOf(40))
                .internet(BigDecimal.valueOf(30))
                .construir());
    }
}
