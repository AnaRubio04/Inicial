/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteco;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author Diurno
 */
public class Biblioteca {
    private int secciones;
    private String nombre;
    private String direccion;
    private int numItems;
    private int numPlaza;
    private Map fondo; 

    public Biblioteca(int secciones, String nombre, String direccion, int numItems, int numPlaza, Map fondo) {
        this.secciones = secciones;
        this.nombre = nombre;
        this.direccion = direccion;
        this.numItems = numItems;
        this.numPlaza = numPlaza;
        this.fondo = fondo;
    }

    @SuppressWarnings("unchecked")
    public void alta_item(Item item){
        fondo.put(item.getTitulo(), item);
        numItems++;
    }

    public void baja_item(String titulo){
        if(fondo.remove(titulo) != null){
            numItems--;
        }
    }

    @SuppressWarnings("unchecked")
    public void listadoDeLibros(){
        System.out.println("ISBN\tTítutlo\tTemática"); //encabezado
        fondo.values() //se refiere a todo el contenido del map
        .stream() //permite que se pueda recorrer los elementos
        .filter(item-> item instanceof Libro) //filtra los elementos para obtener solo las instancias de libro
        .map(item -> (Libro)item) //mapea los elementos a tipo libro
        .forEach(libro -> System.out.println(((Libro) libro).getISBN() + "\t" + ((Libro) libro).getAutor() + "\t" + ((Libro) libro).getTematica())); //recorrer cada libro (o elemento) y mostrar la informacion accediendo a sus metodos
    }

    @SuppressWarnings("unchecked")
    public void listadoDeRevistas(){
        System.out.println("Número\tAdjunto"); //encabezado
        fondo.values() //se refiere a todo el contenido del map
        .stream() //permite que se pueda recorrer los elementos
        .filter(item-> item instanceof Revista) //filtra los elementos para obtener solo las instancias de Revista
        .map(item -> (Revista)item) //mapea los elementos a tipo Revista
        .forEach(revista -> System.out.println(((Revista) revista).getNumRevista() + "\t" + ((Revista) revista).getAdjunto())); //recorrer cada Revista (o elemento) y mostrar la informacion accediendo a sus metodos
    }

    @SuppressWarnings("unchecked")
    public void listadoFondo(){
        System.out.println("Items en la biblioteca");
        //primero ordenamos los libros
        List<Item> libros = (List<Item>) fondo.values().stream() //accedemos a todos los elementos del map
                .filter(item -> item instanceof Libro) //filtramos para ordenar solo los libros
                .sorted((item1, item2) -> ((Item) item1).getTitulo().compareTo(((Item) item2).getTitulo())) //comparamos si el primer libro es igual que el segundo para ordenar alfabeticamente
                .collect(Collectors.toList()); //pasamos el mapa a una lista
        //despues ordenamos las revistar
        List<Item> revistas = (List<Item>) fondo.values().stream() //accedemos a todos los elementos del map
                .filter(item -> item instanceof Revista) //filtramos para ordenar solo los libros
                .sorted((item1, item2) ->
                {
                    Revista revista1 = (Revista) item1;
                    Revista revista2 = (Revista) item2;
                    return revista1.getNumRevista().compareTo(revista2.getNumRevista());
                }) //creamos dos revistas para poder acceder a su numero y luego compramos pr numero
                .collect(Collectors.toList()); //pasamos el mapa a una lista

        //imprimir item por item
        List<Item> todosItems = new ArrayList<>();
        //agregamos los libros y las revistas a la lista ordenadas
        todosItems.addAll(libros);
        todosItems.addAll(revistas);

        //imprimir la lista de todosItems
        todosItems.forEach(item -> {
            if(item instanceof Libro){
                Libro libro = (Libro) item;
                System.out.println(libro.getISBN() + "\t" + libro.getAutor() + "\t" + libro.getTematica());
            }else if (item instanceof Revista){
                Revista revista = (Revista) item;
                System.out.println(revista.getNumRevista() + "\t" + revista.getAdjunto());
            }
        });
    }

    @SuppressWarnings("unchecked")
    public void listadoPorTema(String tema){
        System.out.println("Items de la temática: " + tema);
        fondo.values().stream()
                .filter(item -> ((Item) item).getTematica().equalsIgnoreCase(tema))
                .forEach(item -> System.out.println(((Item) item).getTitulo() + " - " + ((Item) item).getTematica()));
        
    }




    
    
}

