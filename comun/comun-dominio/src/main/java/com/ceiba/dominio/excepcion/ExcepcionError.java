package com.ceiba.dominio.excepcion;

public class ExcepcionError extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionError(String mensaje) {
        super(mensaje);
    }
}
