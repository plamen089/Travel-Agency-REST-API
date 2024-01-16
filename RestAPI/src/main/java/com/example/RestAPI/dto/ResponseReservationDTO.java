package com.example.RestAPI.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseReservationDTO {

    private long id;
    private String contactName;
    private String phoneNumber;
    private ResponseHolidayDTO responseHolidayDTO;
}
