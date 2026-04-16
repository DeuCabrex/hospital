package com.hospital.atenciones.services;

import com.hospital.atenciones.models.Atenciones;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AtencionesService {
    List<Atenciones> findAll ();
    Atenciones save(Atenciones atenciones);
}
