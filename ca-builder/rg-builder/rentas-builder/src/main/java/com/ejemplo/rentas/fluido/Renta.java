package com.ejemplo.rentas.fluido;

import java.math.BigDecimal;

/** Producto del Builder fluido. Un componente sin asignar es null. */
public class Renta {

    private BigDecimal canonArrendamiento;
    private BigDecimal alicuota;
    private BigDecimal agua;
    private BigDecimal electricidad;
    private BigDecimal internet;
    private BigDecimal parqueadero;
    private BigDecimal otrosCargos;

    BigDecimal getCanonArrendamiento() { return canonArrendamiento; }
    BigDecimal getAlicuota() { return alicuota; }
    BigDecimal getAgua() { return agua; }
    BigDecimal getElectricidad() { return electricidad; }
    BigDecimal getInternet() { return internet; }
    BigDecimal getParqueadero() { return parqueadero; }
    BigDecimal getOtrosCargos() { return otrosCargos; }

    void setCanonArrendamiento(BigDecimal valor) { canonArrendamiento = valor; }
    void setAlicuota(BigDecimal valor) { alicuota = valor; }
    void setAgua(BigDecimal valor) { agua = valor; }
    void setElectricidad(BigDecimal valor) { electricidad = valor; }
    void setInternet(BigDecimal valor) { internet = valor; }
    void setParqueadero(BigDecimal valor) { parqueadero = valor; }
    void setOtrosCargos(BigDecimal valor) { otrosCargos = valor; }

    @Override
    public String toString() {
        return "Renta{canonArrendamiento=" + canonArrendamiento + ", alicuota=" + alicuota
                + ", agua=" + agua + ", electricidad=" + electricidad + ", internet=" + internet
                + ", parqueadero=" + parqueadero + ", otrosCargos=" + otrosCargos + "}";
    }
}
