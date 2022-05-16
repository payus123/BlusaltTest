package com.blusalt.customerservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceResponse<T> {

    private String code;
    private String description;
    private T data;

    public ServiceResponse(String code, String description) {
        this.code = code;
        this.description = description;
    }

}
