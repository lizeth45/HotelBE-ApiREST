package com.app.hotel.jpa;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.hotel.entity.ServiciosCons;
import com.app.hotel.entity.ServiciosConsID;

public interface IServiciosCons extends JpaRepository <ServiciosCons,ServiciosConsID> {

	@Query(value= "call agregarServiciosEstancia(:id_estanciap, :desc_serviciop, :pres)", nativeQuery=true)
    Integer agregarServiciosEstancia(
        @Param("id_estanciap") int idEstancia,
        @Param("desc_serviciop") String descServicio,
        @Param("pres") Integer cantidadSolicitada
    );
}
