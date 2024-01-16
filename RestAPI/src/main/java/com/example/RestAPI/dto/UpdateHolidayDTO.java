package com.example.RestAPI.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class UpdateHolidayDTO {

    private long id;
    private long location;
    private String title;
    private LocalDate startDate;
    private Integer duration;
    private String price;
    private Integer freeSlots;

}
