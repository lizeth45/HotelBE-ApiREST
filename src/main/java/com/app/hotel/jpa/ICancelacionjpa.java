package com.app.hotel.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.hotel.entity.Cancelacion;

public interface ICancelacionjpa extends JpaRepository<Cancelacion, Integer>{
	 @Query("SELECT c FROM Cancelacion c WHERE c.idCancelacion = :id")
	  List<Cancelacion> buscarPorId(@Param("id") int id);
	 
	 
	 @Query(value= "call procesoCancelacion(:id_reservap, :motivop, :pres)", nativeQuery=true)
	    String procesoCancelacion(
	        @Param("id_reservap") int idReserva,
	        @Param("motivop") String motivo,
	        @Param("pres") String resultado
	    );
}
