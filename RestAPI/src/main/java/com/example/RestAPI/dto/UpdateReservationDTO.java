package com.example.RestAPI.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateReservationDTO {

    private long id;
    private String contactName;
    private String phoneNumber;
    private long holiday;

}
