package com.hospital.atenciones.models;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table(name = "pacientes")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paciente")
    private Long id_paciente;


    @NotBlank(message = "El campo rut no puede ser vacio")
    @Column(unique = true, nullable = false)
    @Pattern(regexp = "\\d{1,8}-[\\dKk]", message = "El formato del run tiene que ser XXXXXXXX-X")

    private String rut;

    @NotBlank(message = "El campo nombres no puede ser vacio")
    @Column(nullable = false)
    private String nombres;


    @NotBlank(message = "El campo apellidos no puede ser vacio")
    @Column(nullable = false)
    private String apellidos;


    @NotNull(message = "El campo de fecha nacimiento no puede ser vacio")
    @Column(nullable = false)
    private LocalDate fechaNacimiento;

    @Email(message = "El correo tiene que tener formato de correo")
    @NotBlank(message = "El correo no puede ser vacio")
    @Column(nullable = false, unique = true)
    private String correoElectronico;

    @Embedded
    private Audit audit = new Audit();

}
