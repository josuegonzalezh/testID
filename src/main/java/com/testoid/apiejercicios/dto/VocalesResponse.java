package com.testoid.apiejercicios.dto;

public class VocalesResponse {

    private String mensaje;

    public VocalesResponse(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
