package com.app.hotel.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.hotel.entity.Facturacion;

public interface IFacturacionjpa extends JpaRepository < Facturacion, Integer>{

	@Query("SELECT c FROM Facturacion c WHERE c.idFactura = :id")
	  List<Facturacion> buscarPorId(@Param("id") int id);
	
	
	@Query(value= " call facturar_finalizarestancia(:id_estancia,:pres);", nativeQuery=true)
    String facturar_finalizarestancia(
        @Param("id_estancia") int id_estancia,
        @Param("pres") String resultado
    );
}
