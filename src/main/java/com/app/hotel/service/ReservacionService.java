package com.app.hotel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.hotel.jpa.IReservacionjpa;

@Service
public class ReservacionService implements IReservacionService {
	
	private IReservacionjpa repoReserva;
	
//	@Override
//	public List<Object[]> reservaPenddelDia(){
//		return repoReserva.reservasPendientesHoy();
//	}
}
