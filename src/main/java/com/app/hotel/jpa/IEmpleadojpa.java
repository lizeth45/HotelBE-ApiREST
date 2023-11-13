package com.app.hotel.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.hotel.entity.Empleado;

public interface IEmpleadojpa extends JpaRepository <Empleado, Integer>{

	@Query("SELECT c FROM Empleado c WHERE c.userEmpleado = :user AND c.passEmpleado = :pass")
	  List<Empleado> buscarUserLogin(@Param("user") String user, @Param("pass") String pass);
}
