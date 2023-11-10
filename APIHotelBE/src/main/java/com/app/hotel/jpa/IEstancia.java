package com.app.hotel.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.hotel.entity.Estancia;

public interface IEstancia extends JpaRepository< Estancia, Integer>{

	 @Query("SELECT c FROM Estancia c WHERE c.idEstancia = :id")
	  List<Estancia> buscarPorId(@Param("id") int id);
}
