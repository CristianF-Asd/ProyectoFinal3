package com.example.proyectofinal1;

public class PlasticModel {
    String plasticFullName;
    String plasticAbbrName;
    int imagen;
    String description;
    String example;
    boolean visibility;

    public PlasticModel(String plasticFullName, String plasticAbbrName, int imagen, String description, String example) {
        this.plasticFullName = plasticFullName;
        this.plasticAbbrName = plasticAbbrName;
        this.imagen = imagen;
        this.description = description;
        this.example = example;
        this.visibility = false;
    }

    public String getPlasticFullName() {
        return plasticFullName;
    }

    public String getPlasticAbbrName() {
        return plasticAbbrName;
    }

    public int getImagen() {
        return imagen;
    }

    public String getDescription() {
        return description;
    }

    public String getExample() {
        return example;
    }

    public boolean isVisibility() {
        return visibility;
    }

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }
}
