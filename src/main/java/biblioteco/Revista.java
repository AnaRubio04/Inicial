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
public class Revista extends Item{
    private String numRevista;
    private String adjunto;

    public Revista(String titulo, short numpags, String editorial, LocalDate fechapubli, boolean estaPrestado, String tematica,String numRevista, String adjunto) {
        super(titulo, numpags, editorial, fechapubli, estaPrestado, tematica);
        this.numRevista = numRevista;
        this.adjunto = adjunto;
    }

    public String getNumRevista() {
        return numRevista;
    }

    public void setNumRevista(String numRevista) {
        this.numRevista = numRevista;
    }

    public String getAdjunto() {
        return adjunto;
    }

    public void setAdjunto(String adjunto) {
        this.adjunto = adjunto;
    }
    
}
