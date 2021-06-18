package com.ceiba.dominio.excepcion;

public class ExcepcionErrorFecha extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionErrorFecha(String mensaje) {
        super(mensaje);
    }
}
