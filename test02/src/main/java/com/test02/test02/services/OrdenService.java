package com.test02.test02.services;

import com.test02.test02.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdenService {
    public void saveOrder(List<Product> products){
        System.out.println("saving in the database ... ");
    }
}
