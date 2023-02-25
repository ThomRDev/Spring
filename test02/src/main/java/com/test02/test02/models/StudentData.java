package com.test02.test02.models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public class StudentData {
    // si queremos una variable ya que la vamos a manipular a nivel de codigo
    // pero queremos que no se muestre en el json a retornar
    @JsonIgnore
    public int password;

    // si queremos que al serealizar se cambie de nombre de ese campo
    // lo que se recibira en el responde será real_address en lugar de address
    @JsonProperty("real_address")
    public String address;

    public String name;

    // esto reemplazara todo el json
    /*@JsonValue
    public String info(){
        return "Soy "+this.name+" y mi direccion es "+this.address;
    }*/

    // se creara una propiedad "information"
    @JsonGetter("information")
    public String _information(){
        return "Soy "+this.name+" y mi direccion es "+this.address;
    }

    public StudentData(int password,String name,String address){
        this.password = password;
        this.name = name;
        this.address = address;
    }
}
