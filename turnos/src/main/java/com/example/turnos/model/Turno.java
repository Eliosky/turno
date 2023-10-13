
package com.example.turnos.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Turno {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_turno;
    @Temporal (TemporalType.DATE)  
    private LocalDate fecha;
    private String tratamiento;
    private String nombreCompletoPaciente;
    
}
