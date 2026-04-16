package com.hospital.atenciones.services;
import com.hospital.atenciones.models.Atenciones;
import com.hospital.atenciones.repositories.AtencionesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AtencionesServiceImpl implements AtencionesService {
    @Autowired
    private AtencionesRepository atencionesRepository;


    @Override
    public List<Atenciones> findAll() {
        return List.of();
    }

    @Override
    public Atenciones save(Atenciones atenciones) {
        return null;
    }
}
