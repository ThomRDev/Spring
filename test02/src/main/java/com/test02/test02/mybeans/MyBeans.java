package com.test02.test02.mybeans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// con esta anotacion le decimos que esta clase contendra declaraciones de beans
// bean singleton, se podra inyectar
@Configuration
public class MyBeans {

    @Bean
    public MyBean createBean(){
        return new MyBean();
    }

}
