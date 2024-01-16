package com.example.RestAPI.service;

import com.example.RestAPI.dto.CreateHolidayDTO;
import com.example.RestAPI.dto.ResponseHolidayDTO;
import com.example.RestAPI.dto.UpdateHolidayDTO;
import com.example.RestAPI.mapper.HolidayMapper;
import com.example.RestAPI.model.Holiday;
import com.example.RestAPI.repository.HolidayRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HolidayService {

    private final HolidayRepository holidayRepository;
    private final HolidayMapper holidayMapper;

    @Autowired
    public HolidayService(HolidayRepository holidayRepository, HolidayMapper holidayMapper) {
        this.holidayRepository = holidayRepository;
        this.holidayMapper = holidayMapper;
    }

    @Transactional(readOnly = true)
    public List<ResponseHolidayDTO> getAllHolidays() {
        return holidayRepository.findAll().stream()
                .map(holidayMapper::holidayToResponseDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public ResponseHolidayDTO createHoliday(CreateHolidayDTO createHolidayDTO) {
        Holiday holiday = holidayMapper.createDtoToHoliday(createHolidayDTO);
        Holiday savedHoliday = holidayRepository.save(holiday);
        return holidayMapper.holidayToResponseDto(savedHoliday);
    }

    @Transactional
    public ResponseHolidayDTO updateHoliday(Long id, UpdateHolidayDTO updateHolidayDTO) {
        Holiday existingHoliday = holidayRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Holiday not found"));

        Holiday updatedHoliday = holidayRepository.save(existingHoliday);
        return holidayMapper.holidayToResponseDto(updatedHoliday);
    }

    @Transactional
    public void deleteHoliday(Long id) {
        holidayRepository.deleteById(id);
    }

}
