/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteco;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Diurno
 */
public class Usuario {
    private String nombre;
    private String dni;
    private int numeroSocio;
    private String telefono;
    private List<Item> itemsPrestados;
    private boolean estaSancionado;

    public Usuario(String nombre, String dni, int numeroSocio, String telefono) {
        this.nombre = nombre;
        this.dni = dni;
        this.numeroSocio = numeroSocio;
        this.telefono = telefono;
        this.itemsPrestados = new ArrayList<>();
        this.estaSancionado = false;
    }

    public boolean getEstaSancionado() {
        return estaSancionado;
    }
    public void setEstaSancionado(boolean sancion){
        this.estaSancionado = sancion;
    }

    public void tomarItemPrestado(Item item){
        if(!estaSancionado && itemsPrestados.size() < 5 && !item.isEstaPrestado()){
            itemsPrestados.add(item);
            item.setEstaPrestado(true);
            System.out.println("Se ha tomado prestado el item: " + item.getTitulo());
        }else{
            if(estaSancionado){
                System.out.println("El usuario se encuentra sancionado, no puede tomar el item");
            }else if(item.isEstaPrestado()){
                System.out.println("El item ya ha sido prestado");
            }else{
                System.out.println("El usuario ya tiene el maximo de items prestados");
            }
        }
    }

    public void devolverItem(Item item){
        if(itemsPrestados.remove(item)){
            item.setEstaPrestado(false);
            System.out.println("Se ha devuelto el item: " + item.getTitulo());
        }else{
            System.out.println("El item no se encuentra prestado");
        }
    }
    
    public void listadoDeItemsPrestados(){
        System.out.println("Items prestados por : " + nombre + ": ");
        for(Item item: itemsPrestados){
            System.out.println(item.getTitulo());
        }
    }



}
