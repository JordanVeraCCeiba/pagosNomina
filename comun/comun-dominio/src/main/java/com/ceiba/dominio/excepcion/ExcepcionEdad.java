package com.ceiba.dominio.excepcion;

public class ExcepcionEdad extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionEdad(String mensaje) {
        super(mensaje);
    }
}
