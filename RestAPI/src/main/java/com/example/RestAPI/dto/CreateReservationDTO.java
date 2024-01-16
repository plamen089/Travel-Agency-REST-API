package com.example.RestAPI.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateReservationDTO {

    private String contactName;
    private String phoneNumber;
    private long holiday;

}
