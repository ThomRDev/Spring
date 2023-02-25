package com.apirest.apirest.repository;
import com.apirest.apirest.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository("productRepository")
public interface ProductRepository extends JpaRepository<Product, Integer> {

}

// en el caso que no utilice el patron reporitory puedo utilzar la estrategia DAO que me permitira
// poder para acceder a los datos.

/*
El patrón DAO es una forma común de encapsular el acceso a una fuente de datos en un objeto
que proporciona una interfaz de alto nivel para acceder a los datos. En lugar de interactuar directamente
con una base de datos, por ejemplo, el código de tu aplicación interactuaría con los métodos de un objeto
DAO que se encarga de realizar las operaciones de acceso a los datos necesarias.
 */