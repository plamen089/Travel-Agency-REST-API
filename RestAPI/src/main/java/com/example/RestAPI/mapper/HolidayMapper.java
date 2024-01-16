package com.example.RestAPI.mapper;

import com.example.RestAPI.dto.CreateHolidayDTO;
import com.example.RestAPI.dto.ResponseHolidayDTO;
import com.example.RestAPI.dto.UpdateHolidayDTO;
import com.example.RestAPI.model.Holiday;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
public interface HolidayMapper {
    HolidayMapper INSTANCE = Mappers.getMapper(HolidayMapper.class);

    Holiday createDtoToHoliday(CreateHolidayDTO dto);

    ResponseHolidayDTO holidayToResponseDto(Holiday holiday);

    @Mapping(target = "id", ignore = true)
    Holiday updateDtoToHoliday(UpdateHolidayDTO dto);
}
