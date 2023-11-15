package com.app.hotel.jpa;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.hotel.entity.ReservaHab;
import com.app.hotel.entity.ReservaHabID;
@Repository
public interface IReservaHab extends JpaRepository < ReservaHab, ReservaHabID>{

	@Query(value= "call procesoReservacionHab(:fecha_llegadap, :fecha_salidap , :tipoHabp , :pres)", nativeQuery=true)
    String procesoReservacionHab(
        @Param("fecha_llegadap") Date fechaLlegada,
        @Param("fecha_salidap") Date fechaSalida,
        @Param("tipoHabp") String tipoHabitacion,
        @Param("pres") String resultado
    );
}
