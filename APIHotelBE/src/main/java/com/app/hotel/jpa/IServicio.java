package com.app.hotel.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.hotel.entity.Servicio;

public interface IServicio extends JpaRepository<Servicio, Integer> {

	@Query("SELECT c FROM Servicio c WHERE c.idServicio = :id")
	  List<Servicio> buscarPorId(@Param("id") int id);
}
