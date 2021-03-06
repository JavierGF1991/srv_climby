package com.climbtogether.climby.service;

import org.springframework.stereotype.Service;

import com.climbtogether.climby.dto.ReservationDTO;
import com.climbtogether.climby.exceptions.ReservationNotFoundException;

@Service
public interface ReservationService {

	ReservationDTO resgisterReservation(ReservationDTO createReservationDTO);
	
	ReservationDTO modifyReservation(ReservationDTO modifyReservationDTO) throws ReservationNotFoundException;
	
	ReservationDTO getReservationById(Integer id) throws ReservationNotFoundException;
	
	Integer unreadMessages(Integer id) throws ReservationNotFoundException;
	
	void removeReservation(Integer id) throws ReservationNotFoundException;
}
