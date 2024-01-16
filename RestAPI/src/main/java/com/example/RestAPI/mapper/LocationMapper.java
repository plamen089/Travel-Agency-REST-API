package com.example.RestAPI.mapper;

import com.example.RestAPI.dto.CreateLocationDTO;
import com.example.RestAPI.dto.ResponseLocationDTO;
import com.example.RestAPI.dto.UpdateLocationDTO;
import com.example.RestAPI.model.Location;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LocationMapper {

    LocationMapper INSTANCE = Mappers.getMapper(LocationMapper.class);

    Location createDtoToLocation(CreateLocationDTO dto);

    ResponseLocationDTO locationToResponseDto(Location location);

    @Mapping(target = "id", ignore = true)
    Location updateDtoToLocation(UpdateLocationDTO dto);
}