package com.app.hotel.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.hotel.entity.ReservaHab;
import com.app.hotel.entity.ReservaHabID;

public interface IReservaHab extends JpaRepository < ReservaHab, ReservaHabID>{

}
