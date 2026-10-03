package com.ejemplo.rentas.fluido;

import java.math.BigDecimal;

/**
 * Builder fluido: cada método nombra el componente que configura y devuelve el mismo
 * constructor, así la llamada se lee de corrido y el orden no importa.
 */
public class ConstructorRenta {

    private Renta renta = new Renta();

    public ConstructorRenta canonArrendamiento(BigDecimal valor) { renta.setCanonArrendamiento(valor); return this; }

    public ConstructorRenta alicuota(BigDecimal valor) { renta.setAlicuota(valor); return this; }

    public ConstructorRenta agua(BigDecimal valor) { renta.setAgua(valor); return this; }

    public ConstructorRenta electricidad(BigDecimal valor) { renta.setElectricidad(valor); return this; }

    public ConstructorRenta internet(BigDecimal valor) { renta.setInternet(valor); return this; }

    public ConstructorRenta parqueadero(BigDecimal valor) { renta.setParqueadero(valor); return this; }

    public ConstructorRenta otrosCargos(BigDecimal valor) { renta.setOtrosCargos(valor); return this; }

    /** El canon es el único componente obligatorio para cualquier tipo de propiedad. */
    public Renta construir() {
        if (renta.getCanonArrendamiento() == null) {
            throw new IllegalStateException("El canon de arrendamiento es obligatorio");
        }
        Renta resultado = renta;
        renta = new Renta();
        return resultado;
    }
}
