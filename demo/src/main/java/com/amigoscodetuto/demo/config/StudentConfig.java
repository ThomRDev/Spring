package com.amigoscodetuto.demo.config;

import com.amigoscodetuto.demo.domain.Student;
import com.amigoscodetuto.demo.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

//La anotación @Configuration en Spring indica que una clase es una clase de configuración de Spring, es decir, que se encarga de configurar y definir beans de la aplicación.
//un Bean es simplemente un objeto que es instanciado, ensamblado y gestionado por el contenedor de Spring

/*Por defecto, los "beans" en Spring son "singleton", lo que significa que sólo hay una instancia
de cada "bean" en todo el contenedor. Sin embargo, también es posible configurar un "bean" para que no sea
"singleton" y se cree una nueva instancia cada vez que se solicita al contenedor.*/
@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            var thom = new Student();
            thom.setName("Thom");
            thom.setAge(24);
            thom.setEmail("thomtwd@gmail.com");
            thom.setDateOfBirth(LocalDate.of(1998, Month.APRIL,17));

            var maria = new Student();
            maria.setName("Maria");
            maria.setAge(23);
            maria.setEmail("maria@gmail.com");
            maria.setDateOfBirth(LocalDate.of(1999, Month.DECEMBER,17));

            repository.saveAll(
                    List.of(thom,maria)
            );
        };
    }
}

/*
    Esta clase sirve para definir la configuración de los beans en una aplicación Spring.
        En particular, en este caso, la clase StudentConfig define un bean llamado commandLineRunner
        que implementa la interfaz CommandLineRunner. Cuando la aplicación arranca, Spring ejecutará el
        método run() de este bean y pasará los argumentos de línea de comandos como un parámetro.

        En este ejemplo en particular, el bean se utiliza para insertar algunos registros de estudiante
        en la base de datos al iniciar la aplicación, utilizando el repositorio StudentRepository. Es una
        forma útil de inicializar datos de prueba o datos por defecto en la aplicación.*/
