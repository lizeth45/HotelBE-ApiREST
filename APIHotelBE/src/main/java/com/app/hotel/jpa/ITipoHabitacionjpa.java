package com.app.hotel.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.hotel.entity.TipoHabitacion;

public interface ITipoHabitacionjpa extends JpaRepository <TipoHabitacion,Integer> {

	@Query("SELECT c FROM TipoHabitacion c WHERE c.idTHabitacion = :id")
	  List<TipoHabitacion> buscarPorId(@Param("id") int id);
}
