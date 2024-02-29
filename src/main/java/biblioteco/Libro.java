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
public class Libro extends Item{
    private String autor;
    private String ISBN;
    

    public Libro(String titulo, short numpags, String editorial, LocalDate fechapubli, boolean estaPrestado, String tematica, String autor, String ISBN) {
        super(titulo, numpags, editorial, fechapubli, estaPrestado, tematica);
        this.autor = autor;
        this.ISBN = ISBN;
    }


    public String getAutor() {
        return autor;
    }


    public void setAutor(String autor) {
        this.autor = autor;
    }


    public String getISBN() {
        return ISBN;
    }


    public void setISBN(String iSBN) {
        ISBN = iSBN;
    }

    
}
