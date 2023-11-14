package com.app.hotel.jpa;


import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.hotel.dto.ReservacionesPendDia;
import com.app.hotel.entity.Reservacion;

@Repository
public interface IReservacionjpa extends JpaRepository<Reservacion, Integer> {
	
	 @Procedure(procedureName= "verificar_disponibilidad")
	    Integer verificarDisponibilidad(
	        @Param("pfecha_llegada") Date fechaLlegada,
	        @Param("pfecha_salida") Date fechaSalida,
	        @Param("ptipo_habitacion") String tipoHabitacion,
	        @Param("pcantidad_solicitada") Integer cantidadSolicitada,
	        @Param("res") Integer resultado
	    );
	 
	 
	 @Procedure(procedureName= "procesoReservacion")
	    Integer resprocesoReservacion(
	        @Param("pfecha_llegada") Date fechaLlegada,
	        @Param("nombrep") String nombreCliente,
	        @Param("ap_patp") String apPaterno,
	        @Param("ap_matp") String apMaterno,
	        @Param("telefonop") String telefonoCli,
	        @Param("rfcp") String rfcCli,
	        @Param("emailp") String email,
	        @Param("direccionp") String direccion,
	        @Param("resul") Integer resultado
	    );

	 @Query(value="select re.id_reserva, CONCAT(c.nombre, ' ', c.ap_pat, ' ', c.ap_mat) "+
			 "as cliente, c.telefono, c.email from clientes c inner join reservacion re "+
			 "on c.id_cliente=re.id_cliente where re.estado = 'PENDIENTE' and re.id_reserva in "+
			 " (SELECT DISTINCT(id_reserva) from reserva_hab where fecha_llegada=CURRENT_DATE)", nativeQuery = true)
     List<ReservacionesPendDia> obtenerReservasPendientesHoy();
	 
	 
	 @Query("UPDATE Reservacion r SET r.estado = 'ACTIVA' WHERE r.idReservacion = :idReservacion")
	    int actualizarEstadoReservacion( @Param("idReservacion") int idReservacion);
	 
	 @Query(value="SELECT COUNT(*) "
	 		+ " FROM habitacion h"
	 		+ " WHERE h.id_thab = :idthab"
	 		+ " AND h.id_hab NOT IN ("
	 		+ " SELECT rh.id_hab"
	 		+ " FROM reserva_hab rh"
	 		+ " WHERE rh.fecha_llegada <= :fecha_salida"
	 		+ " AND rh.fecha_salida >= :fecha_llegada"
	 		+ " )", nativeQuery=true)
	    int disponibilidad( @Param("idthab") int idTHab, @Param("fecha_salida") Date fechSalida, @Param("fecha_llegada") Date fechLlegada);
}
