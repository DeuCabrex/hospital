package com.hospital.atenciones.services;

import com.hospital.atenciones.models.Paciente;

import java.util.List;

public interface PacienteService {

    List<Paciente>findAll();
    Paciente findById(Long id);
    Paciente save(Paciente paciente);
    void deleteById(Long id);
    Paciente updateById(Long id, Paciente paciente);
    Paciente findByCorreo(String correoElectronico);
    Paciente findByRut(String rut);
}
