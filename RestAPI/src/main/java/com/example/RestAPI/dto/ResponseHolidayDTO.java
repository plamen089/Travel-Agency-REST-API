package com.example.RestAPI.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class ResponseHolidayDTO {

    private long id;
    private ResponseLocationDTO responseLocationDTO;
    private String title;
    private LocalDate startDate;
    private Integer duration;
    private Double price;
    private Integer freeSlots;

}
