package com.ejemplo.rentas.sinpatron;

import java.math.BigDecimal;

/**
 * Renta sin patrón: un constructor con todos los componentes.
 * Es fácil confundir el orden de los parámetros y no queda claro cuáles son opcionales.
 */
public class Renta {

    private final BigDecimal canonArrendamiento;
    private final BigDecimal alicuota;
    private final BigDecimal agua;
    private final BigDecimal electricidad;
    private final BigDecimal internet;
    private final BigDecimal parqueadero;
    private final BigDecimal otrosCargos;

    public Renta(BigDecimal canonArrendamiento, BigDecimal alicuota, BigDecimal agua,
                 BigDecimal electricidad, BigDecimal internet, BigDecimal parqueadero,
                 BigDecimal otrosCargos) {
        this.canonArrendamiento = canonArrendamiento;
        this.alicuota = alicuota;
        this.agua = agua;
        this.electricidad = electricidad;
        this.internet = internet;
        this.parqueadero = parqueadero;
        this.otrosCargos = otrosCargos;
    }

    @Override
    public String toString() {
        return "Renta{canonArrendamiento=" + canonArrendamiento + ", alicuota=" + alicuota
                + ", agua=" + agua + ", electricidad=" + electricidad + ", internet=" + internet
                + ", parqueadero=" + parqueadero + ", otrosCargos=" + otrosCargos + "}";
    }
}
