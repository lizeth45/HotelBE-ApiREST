package com.app.hotel.jpa;


import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

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

}
