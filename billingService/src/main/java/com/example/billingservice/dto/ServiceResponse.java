package com.example.billingservice.dto;

import lombok.Data;

@Data
public class ServiceResponse<T> {

    private String code;
    private String description;
    private T data;

    public ServiceResponse(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public ServiceResponse(String code, String description, T data) {
        this.code = code;
        this.description = description;
        this.data = data;
    }


}
