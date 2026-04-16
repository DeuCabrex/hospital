package com.hospital.atenciones.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@Table(name = "atenciones")
@Entity
@ToString
@NoArgsConstructor
public class Atenciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_atencion")
    private Long idAtencion;

    @NotNull(message = "El campo de hora atencion no puede ser vacio")
    @Column(name = "hora_atencion", nullable = false)
    private LocalDateTime horaAtencion;


    @NotNull(message = "El campo de costo no puede ser vacio")
    @Column(nullable = false)
    private double costo;

    private String comentario;

    @NotNull(message = "El campo medico no puede ser vacio")
    @ManyToOne
    @JoinColumn(name = "medico_id", nullable = false)
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    @NotNull(message = "El campo paciente no puede ser vacio")
    private Paciente paciente;


}
