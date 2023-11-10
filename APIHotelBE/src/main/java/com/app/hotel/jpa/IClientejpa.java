package com.app.hotel.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.hotel.entity.Cliente;

public interface IClientejpa extends JpaRepository<Cliente, Integer>{
	 
	 @Query("SELECT c FROM Cliente c WHERE c.idCliente = :id")
	  List<Cliente> buscarPorId(@Param("id") int id);
}
