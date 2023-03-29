package com.amigoscodetuto.demo.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.Period;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
// si no tiene el @Column tomara por defecto el nombre de la variable
@Entity
@Table(name = "student")
public class Student {

    @Id
    @SequenceGenerator(
        name = "student_sequence",
        sequenceName = "student_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "student_sequence"
    )
    private Long id;

//    una sequence es un objeto que se utiliza para generar números secuenciales únicos en una tabla. Una sequence es una base de datos independiente y se puede utilizar en múltiples tablas. Por ejemplo, se puede utilizar para generar automáticamente un número de ID único para cada registro insertado en una tabla.

    private String name;
    private String email;
    private LocalDate dateOfBirth;

//significa que este campo no existira en la base de datos, por ejemplo podemos calcular la edad
//    con la fecha de nacimiento
//    @Transient
    // tenemos que quitar todas las relaciones que haya en otras clases
    private Integer age;

    /*public Integer getAge(){
        return Period.between(this.dateOfBirth,LocalDate.now()).getYears();
    }*/
}
