package com.soapnumber;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.webservicesoap.converter.BinaryConversionRequest;
import org.webservicesoap.converter.BinaryConversionResponse;

@Endpoint
public class ConverterEndpoint {
    private static final String NAMESPACE = "http://www.webservicesoap.org/converter";

    @Autowired
    private ConverterService service;

    @PayloadRoot(localPart = "BinaryConversionRequest", namespace = NAMESPACE)
    @ResponsePayload
    public BinaryConversionResponse binaryConversionResponse(@RequestPayload BinaryConversionRequest request) {
        return service.binary(request);
    }
}
