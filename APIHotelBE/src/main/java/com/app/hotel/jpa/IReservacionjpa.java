package com.app.hotel.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import com.app.hotel.entity.Reservacion;

public interface IReservacionjpa extends JpaRepository<Reservacion, Integer> {

}
