package com.example.RestAPI.service;

import com.example.RestAPI.dto.CreateLocationDTO;
import com.example.RestAPI.dto.ResponseLocationDTO;
import com.example.RestAPI.dto.UpdateLocationDTO;
import com.example.RestAPI.mapper.LocationMapper;
import com.example.RestAPI.model.Location;
import com.example.RestAPI.repository.LocationRepostiory;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class LocationService {


    private final LocationRepostiory locationRepository;
    private final LocationMapper locationMapper;

    @Autowired
    public LocationService(LocationRepostiory locationRepository, LocationMapper locationMapper) {
        this.locationRepository = locationRepository;
        this.locationMapper = locationMapper;
    }

    @Transactional(readOnly = true)
    public List<ResponseLocationDTO> getAllLocations() {
        return locationRepository.findAll().stream()
                .map(locationMapper::locationToResponseDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public ResponseLocationDTO createLocation(CreateLocationDTO createLocationDTO) {
        Location location = locationMapper.createDtoToLocation(createLocationDTO);
        Location savedLocation = locationRepository.save(location);
        return locationMapper.locationToResponseDto(savedLocation);
    }

    @Transactional
    public ResponseLocationDTO updateLocation(Long id, UpdateLocationDTO updateLocationDTO) {
        Location existingLocation = locationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Location not found"));

        Location updatedLocation = locationRepository.save(existingLocation);
        return locationMapper.locationToResponseDto(updatedLocation);
    }

    @Transactional
    public void deleteLocation(Long id) {
        locationRepository.deleteById(id);
    }
}
