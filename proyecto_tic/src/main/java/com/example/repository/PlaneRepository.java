package com.example.repository;

import com.example.entities.*;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
@Repository
public interface PlaneRepository extends JpaRepository<Plane, Long> {

    List<Plane> findByIdAirline(Long idAerolinea);

    Plane findByNumeroAndIdAirline(String numero, Long idAereolinea);

    Plane findByNumero(String numero);

    Plane findByIdPlane(Long idPlane);
}
