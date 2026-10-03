package com.ejemplo.contratos.creador;

import com.ejemplo.contratos.modelo.Contrato;

/** Creador abstracto: declara el factory method que las subclases implementan. */
public abstract class CreadorContrato {

    public abstract Contrato crearContrato();
}
