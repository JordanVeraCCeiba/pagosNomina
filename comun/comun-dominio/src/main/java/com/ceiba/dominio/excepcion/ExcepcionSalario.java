package com.ceiba.dominio.excepcion;

public class ExcepcionSalario extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionSalario(String mensaje) {
        super(mensaje);
    }
}
