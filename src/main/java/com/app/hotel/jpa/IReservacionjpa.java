package com.app.hotel.jpa;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.hotel.entity.Reservacion;

public interface IReservacionjpa extends JpaRepository<Reservacion, Integer> {
	
//	@Query("SELECT r.idReservacion, CONCAT(c.nombreCliente, ' ', c.apPat, ' ', c.apMat) AS cliente, c.celular, c.correo FROM Cliente c JOIN c.reservacion r WHERE r.estado = 'PENDIENTE' AND r.idReservacion IN (SELECT DISTINCT rh.idReservacion FROM ReservaHab rh WHERE rh.fechaLlegada = CURRENT_DATE)")
//	List<Object[]> reservasPendientesHoy();
	

}
