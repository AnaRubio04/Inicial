/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package clase.biblioteca;

import biblioteco.Biblioteca;
import biblioteco.Libro;
import biblioteco.Revista;
import biblioteco.Usuario;
import com.github.javafaker.Faker;
import java.time.LocalDate;

// import com.github.javafaker.Faker;
/**
 *
 * @author Diurno
 */
public class Run {
    public static void pruebaBiblioteca(){
        Faker faker = new Faker();
        Biblioteca biblio = new Biblioteca(5, "biblioteca central", faker.address().fullAddress(), 0, 0, null);
        for(int i = 0; i < 50; i++){
            if(i %2 ==0){ //generar libros si es par
                Libro libro = new Libro( faker.book().title(), 
                        (short) faker.number().numberBetween(0, 1000), 
                        faker.book().publisher(),LocalDate.now() ,
                        true,faker.book().genre(),faker.book().author(),
                        faker.code().isbn13());
                biblio.alta_item(libro);
            }else{
                Revista revista = new Revista( faker.book().title(), 
                        (short) faker.number().numberBetween(0, 1000), 
                        faker.book().publisher(),LocalDate.now() ,
                        true,faker.book().genre(),
                    faker.book().author(), faker.dog().memePhrase());
                
                biblio.alta_item(revista);
            }
        }

        for(int i = 0; i < 5; i++){
            Usuario usu = new Usuario(faker.name().firstName(), faker.number().digits(8), i, faker.phoneNumber().phoneNumber());
        }
    }
    
    

    public static void main(String[] args) {
        pruebaBiblioteca();
}
}
