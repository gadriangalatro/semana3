package com.e.petagram;

import java.io.Serializable;

public class Pets implements Serializable {
    int imagen, icHuesoBl, icHuesoAm;
    int votos ;
    String nombre;

    public Pets (int imagen, String nombre){
        this.imagen=imagen;
        this.nombre=nombre;
    }
    public Pets (int imagen, String nombre, int votos){
        this.imagen=imagen;
        this.nombre=nombre;
        this.votos = votos;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public int getIcHuesoBl() {
        return icHuesoBl;
    }

    public void setIcHuesoBl(int icHuesoBl) {
        this.icHuesoBl = icHuesoBl;
    }

    public int getIcHuesoAm() {
        return icHuesoAm;
    }

    public void setIcHuesoAm(int icHuesoAm) {
        this.icHuesoAm = icHuesoAm;
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
