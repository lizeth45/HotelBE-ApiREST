package com.app.hotel.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.hotel.entity.ServiciosCons;
import com.app.hotel.entity.ServiciosConsID;

public interface IServiciosCons extends JpaRepository <ServiciosCons,ServiciosConsID> {

}
