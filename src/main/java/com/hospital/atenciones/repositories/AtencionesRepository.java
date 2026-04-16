package com.hospital.atenciones.repositories;

import com.hospital.atenciones.models.Atenciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtencionesRepository extends JpaRepository<Atenciones, Long> {
}
