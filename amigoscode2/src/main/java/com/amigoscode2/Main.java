package com.amigoscode2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication // combina esas 3 de abajo
//@ComponentScan // se utiliza para buscar componentes de Spring esto incluye componentes como controladores, servicios, repositorios, entre otros.
    //@ComponentScan(basePackages = "com.amigoscode2")
//@EnableAutoConfiguration // configurar automáticamente la aplicación de Spring Boot tomcat etc
// en función de las dependencias que se hayan agregado al proyecto.
//@Component
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }
/*
    record GreetResponse(String greet){}

    // los records son como las clases pero son inmutables
    public record Persona(String nombre, int edad) {
        public String getNombre() {
            return nombre;
        }

        // setter pero creara otro record de PErsona ya que no se puede mutar
        public Persona withNombre(String nombre) {
            return new Persona(nombre, this.edad);
        }
    }

    // asi se usa
    Persona personaOriginal = new Persona("Juan",  30);
    String nombre = persona.nombre();

    Persona personaModificada = personaOriginal.withNombre("Pedro");*/

/*
    Un record es una clase inmutable que se utiliza para modelar datos, y es especialmente útil en situaciones donde se requiere una clase que tenga solamente propiedades, sin métodos adicionales. Por lo tanto, si estás trabajando con datos que no necesitan mucha lógica adicional y que son principalmente para ser almacenados y recuperados, un record puede ser una opción más simple y concisa que una clase normal.

    Por otro lado, si estás modelando un objeto que tiene más comportamiento y métodos más complejos, una clase normal puede ser una opción más apropiada. También, si necesitas tener control total sobre los getters y setters, o necesitas implementar interfaces o heredar de otras clases, una clase normal puede ser la mejor opción. En resumen, el uso de records o clases normales depende del contexto y los requerimientos específicos de cada proyecto.

    los DTO pueden ser records en Java 16 y versiones posteriores. De hecho, los records son una buena opción para representar DTO ya que están diseñados para modelar datos inmutables y tienen una sintaxis más concisa que las clases regulares. Además, los records generan automáticamente constructores, métodos equals(), hashCode() y toString(), lo que simplifica el código que necesitas escribir.
*/

}
