package com.example.RestAPI.controller;

import com.example.RestAPI.model.Holiday;
import com.example.RestAPI.repository.HolidayRepository;
import com.example.RestAPI.service.HolidayService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/holidays")
public class HolidayController {

    private HolidayRepository holidayRepository;

    @GetMapping
    public List<Holiday> getAllHolidays() {
        return holidayRepository.findAll();
    }

    @PostMapping
    public Holiday createHoliday(@RequestBody Holiday holiday) {
        return holidayRepository.save(holiday);
    }

    @PutMapping("/{id}")
    public Holiday updateHoliday(@PathVariable Long id, @RequestBody Holiday holidayDetails) {
        Holiday holiday = holidayRepository.findById(id).orElseThrow(/* exception */);

        return holidayRepository.save(holiday);
    }

    @DeleteMapping("/{id}")
    public void deleteHoliday(@PathVariable Long id) {
        holidayRepository.deleteById(id);
    }
}
