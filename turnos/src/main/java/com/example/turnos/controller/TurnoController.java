
package com.example.turnos.controller;

import com.example.turnos.dto.TurnoDTO;
import com.example.turnos.model.Turno;
import com.example.turnos.service.ITurnoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    
    @Autowired
    private ITurnoService turnoServ;
    
    @PostMapping("/crear")
    public String crearTurno(@RequestBody TurnoDTO turno){
        
        turnoServ.saveTurno(turno.getFecha(), turno.getTratamiento(),
                    turno.getDniPaciente());
        return "Turno creado";
    }
    
    @GetMapping("/traer")
    public List<Turno> traerTurnos(){
        return turnoServ.getTurnos();
    }
    
    @DeleteMapping("/borrar/{id}")
    public String deleteTurno(@PathVariable Long id){
        turnoServ.deleteTurno(id);
        return "El turno fue eliminado";
    }
    
    @PutMapping("/editar/{id_original}")
    public Turno ediTurno (@PathVariable Long id_origina,
                           @RequestBody Turno turnoEditar){
        turnoServ.editTurno(id_origina, turnoEditar);
        Turno turnoEditado = turnoServ.findTurno(id_origina);
        return turnoEditado;
    }
    
    @GetMapping("/traer/{id}")
    public Turno traerTurno(@PathVariable Long id){
        return turnoServ.findTurno(id);
    }
    
}
