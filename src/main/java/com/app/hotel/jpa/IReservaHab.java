package com.app.hotel.jpa;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.hotel.entity.ReservaHab;
import com.app.hotel.entity.ReservaHabID;
@Repository
public interface IReservaHab extends JpaRepository < ReservaHab, ReservaHabID>{

	@Procedure(procedureName= "procesoReservacionHab")
    Integer procesoReservacionHab(
        @Param("fecha_llegadap") Date fechaLlegada,
        @Param("fecha_salidap") Date fechaSalida,
        @Param("tipoHabp") String tipoHabitacion,
        @Param("pres") Integer resultado
    );
}
