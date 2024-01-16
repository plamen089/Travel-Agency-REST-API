package com.example.RestAPI.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseLocationDTO {

    private long id;
    private String street;
    private String number;
    private String city;
    private String country;
    private String imageUrl;
}
