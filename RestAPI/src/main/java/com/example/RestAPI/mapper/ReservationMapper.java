package com.example.RestAPI.mapper;

import com.example.RestAPI.dto.CreateReservationDTO;
import com.example.RestAPI.dto.ResponseReservationDTO;
import com.example.RestAPI.dto.UpdateReservationDTO;
import com.example.RestAPI.model.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReservationMapper {

    ReservationMapper INSTANCE = Mappers.getMapper(ReservationMapper.class);

    @Mapping(target = "holidayId", source = "holiday")
    Reservation createDtoToReservation(CreateReservationDTO dto);

    @Mapping(target = "holiday", source = "holidayId")
    ResponseReservationDTO reservationToResponseDto(Reservation reservation);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "holidayId", source = "holiday")
    Reservation updateDtoToReservation(UpdateReservationDTO dto);
}
