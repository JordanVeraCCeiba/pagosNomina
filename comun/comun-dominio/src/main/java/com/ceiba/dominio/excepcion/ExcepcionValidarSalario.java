package com.ceiba.dominio.excepcion;

public class ExcepcionValidarSalario extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionValidarSalario(String mensaje) {
        super(mensaje);
    }
}
