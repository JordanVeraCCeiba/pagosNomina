package com.ceiba.dominio.excepcion;

public class ExcepcionPagoDomingo extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionPagoDomingo(String mensaje) {
        super(mensaje);
    }
}
