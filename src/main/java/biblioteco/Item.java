/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteco;

import java.time.LocalDate;

/**
 *
 * @author Diurno
 */
public abstract class Item implements Comparable<Item>{
    private String titulo;
    private short numpags;
    private String editorial;
    private LocalDate fechapubli;
    private boolean estaPrestado;
    private String tematica;

    public Item(String titulo, short numpags, String editorial, LocalDate fechapublii, boolean estaPrestado, String tematica) {
        this.titulo = titulo;
        this.numpags = numpags;
        this.editorial = editorial;
        this.fechapubli = fechapubli;
        this.estaPrestado = estaPrestado;
        this.tematica = tematica;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public short getNumpags() {
        return numpags;
    }

    public void setNumpags(short numpags) {
        this.numpags = numpags;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public LocalDate getFechapubli() {
        return fechapubli;
    }

    public void setFechapubli(LocalDate fechapubli) {
        this.fechapubli = fechapubli;
    }

    public boolean isEstaPrestado() {
        return estaPrestado;
    }

    public void setEstaPrestado(boolean estaPrestado) {
        this.estaPrestado = estaPrestado;
    }

    public String getTematica() {
        return tematica;
    }

    public void setTematica(String tematica) {
        this.tematica = tematica;
    }

    @Override
    public int compareTo(Item o){
        return this.getTitulo().compareTo(o.getTitulo());
    }


}


