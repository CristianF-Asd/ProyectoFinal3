package com.example.proyectofinal1.Model;

public class CantRec {

    private int prod0;
    private int prod1;
    private int prod2;
    private int prod3;
    private int prod4;
    private String date;
    private String email;

    public CantRec() {
    }

    public CantRec(int prod0, int prod1, int prod2, int prod3, int prod4, String date, String email) {
        this.prod0 = prod0;
        this.prod1 = prod1;
        this.prod2 = prod2;
        this.prod3 = prod3;
        this.prod4 = prod4;
        this.date = date;
        this.email = email;
    }

    public int getProd0() {
        return prod0;
    }

    public void setProd0(int prod0) {
        this.prod0 = prod0;
    }

    public int getProd1() {
        return prod1;
    }

    public void setProd1(int prod1) {
        this.prod1 = prod1;
    }

    public int getProd2() {
        return prod2;
    }

    public void setProd2(int prod2) {
        this.prod2 = prod2;
    }

    public int getProd3() {
        return prod3;
    }

    public void setProd3(int prod3) {
        this.prod3 = prod3;
    }

    public int getProd4() {
        return prod4;
    }

    public void setProd4(int prod4) {
        this.prod4 = prod4;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
