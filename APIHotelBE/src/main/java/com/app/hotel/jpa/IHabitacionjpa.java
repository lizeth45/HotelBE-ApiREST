package com.app.hotel.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.hotel.entity.Habitacion;

public interface IHabitacionjpa extends JpaRepository <Habitacion,Integer> {

	@Query("SELECT c FROM Habitacion c WHERE c.idHabitacion = :id")
	  List<Habitacion> buscarPorId(@Param("id") int id);
}
