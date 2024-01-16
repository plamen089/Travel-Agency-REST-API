package com.example.RestAPI.service;

import com.example.RestAPI.dto.CreateReservationDTO;
import com.example.RestAPI.dto.ResponseReservationDTO;
import com.example.RestAPI.dto.UpdateReservationDTO;
import com.example.RestAPI.mapper.ReservationMapper;
import com.example.RestAPI.model.Reservation;
import com.example.RestAPI.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final ReservationMapper reservationMapper;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository, ReservationMapper reservationMapper) {
        this.reservationRepository = reservationRepository;
        this.reservationMapper = reservationMapper;
    }

    @Transactional(readOnly = true)
    public List<ResponseReservationDTO> getAllReservations() {
        return reservationRepository.findAll().stream()
                .map(reservationMapper::reservationToResponseDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public ResponseReservationDTO createReservation(CreateReservationDTO createReservationDTO) {
        Reservation reservation = reservationMapper.createDtoToReservation(createReservationDTO);
        Reservation savedReservation = reservationRepository.save(reservation);
        return reservationMapper.reservationToResponseDto(savedReservation);
    }

    @Transactional
    public ResponseReservationDTO updateReservation(Long id, UpdateReservationDTO updateReservationDTO) {
        Reservation existingReservation = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));

        Reservation updatedReservation = reservationRepository.save(existingReservation);
        return reservationMapper.reservationToResponseDto(updatedReservation);
    }

    @Transactional
    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }
}
