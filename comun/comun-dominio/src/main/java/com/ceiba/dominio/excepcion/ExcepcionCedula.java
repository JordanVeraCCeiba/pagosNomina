package com.ceiba.dominio.excepcion;

public class ExcepcionCedula extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionCedula(String mensaje) {
        super(mensaje);
    }
}
