package com.example.proyectofinal1.Model;

public class PerfilClass {
    private String mes;
    private String total;
    private String progreso;

    public PerfilClass() {
    }

    public PerfilClass(String mes, String total, String progreso) {
        this.mes = mes;
        this.total = total;
        this.progreso = progreso;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getProgreso() {
        return progreso;
    }

    public void setProgreso(String progreso) {
        this.progreso = progreso;
    }
}
