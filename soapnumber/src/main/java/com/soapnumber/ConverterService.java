package com.soapnumber;
import org.springframework.stereotype.Service;
import org.webservicesoap.converter.BinaryConversionRequest;
import org.webservicesoap.converter.BinaryConversionResponse;

@Service
public class ConverterService {
    public BinaryConversionResponse binary(BinaryConversionRequest request){
        BinaryConversionResponse binaryConversionResponse = new BinaryConversionResponse();
        String binario = "";
        int numero = request.getNumber();
        while (numero > 0) {
            binario = numero % 2 + binario;
            numero /= 2;
        }
        binaryConversionResponse.setBinary(binario);
        return binaryConversionResponse;
    }
}