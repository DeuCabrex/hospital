package com.hospital.atenciones.services;

import com.hospital.atenciones.exceptions.PacienteException;
import com.hospital.atenciones.models.Paciente;
import com.hospital.atenciones.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PacienteServiceImpl implements PacienteService{

    @Autowired
    public PacienteRepository pacienteRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Paciente> findAll() {
        return this.pacienteRepository.findAll();
    }

    @Transactional
    @Override
    public Paciente findById(Long id) {
        return this.pacienteRepository.findById(id).orElseThrow(
                () -> new PacienteException("Paciente con id "+id+"no encontrado")
        );
    }

    @Override
    public Paciente save(Paciente paciente) {

        if (this.pacienteRepository.findByRut(paciente.getRut()).isPresent()){
            throw new PacienteException("Paciente con el rut: "+paciente.getRut()+"ya existe");
        }
        if (this.pacienteRepository.findByCorreo(paciente.getCorreoElectronico()).isPresent()){
            throw new PacienteException("Paciente con el correo"+paciente.getCorreoElectronico()+" ya existe");
        }
        Paciente newPaciente = new Paciente();
        newPaciente.setRut(paciente.getRut());
        newPaciente.setCorreoElectronico(paciente.getCorreoElectronico());
        newPaciente.setNombres(paciente.getNombres());
        newPaciente.setApellidos(paciente.getApellidos());
        newPaciente.setFechaNacimiento(paciente.getFechaNacimiento());
        return this.pacienteRepository.save(newPaciente);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        this.pacienteRepository.deleteById(id);
    }


    @Transactional
    @Override
    public Paciente updateById(Long id, Paciente paciente) {
        return this.pacienteRepository.findById(id).map(updated -> {
            updated.setNombres(paciente.getNombres());
            updated.setApellidos(paciente.getApellidos());
            updated.setCorreoElectronico(paciente.getCorreoElectronico());
            updated.setFechaNacimiento(paciente.getFechaNacimiento());
            return this.pacienteRepository.save(updated);

        }).orElseThrow(
                () -> new PacienteException("Paciente con id "+id+"no encontrado")
        );
    }

    @Override
    public Paciente findByCorreo(String correoElectronico) {
        return this.pacienteRepository.findByCorreo(correoElectronico).orElseThrow(
                () ->new PacienteException("Paciente no encontrado")
        );
    }

    @Override
    public Paciente findByRut(String rut) {
        return this.pacienteRepository.findByRut(rut).orElseThrow(
                () -> new PacienteException("Paciente no encotrado")
        );
    }
}
