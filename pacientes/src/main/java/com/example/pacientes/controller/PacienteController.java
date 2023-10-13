
package com.example.pacientes.controller;

import com.example.pacientes.model.Paciente;
import com.example.pacientes.service.IPacienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PacienteController {
 
    @Autowired
    private IPacienteService pacienteServ;
    
    @PostMapping("/pacientes/crear")
    public String crearCurso(@RequestBody Paciente pac){
        pacienteServ.savePaciente(pac);
        
        return "Paciente creado";
        
    }
    
    @GetMapping("/pacientes/traer")
    public List<Paciente> traerPaciente(){
        return pacienteServ.getPacientes();
    }
    
    @DeleteMapping("/pacientes/borrar/{id}")
    public String deletePaciente(@PathVariable Long id_original, @RequestBody Paciente pacienteEditar){
        
        pacienteServ.editPaciente(id_original, pacienteEditar);
        Paciente pacienteEditado = pacienteServ.findPaciente(id_original);
        
        return "El paciente fue eliminado";
        
    }
    
    @GetMapping("/pacientes/traer/{id}")
    public Paciente traerPaciente (@PathVariable Long id){
        return pacienteServ.findPaciente(id);
    }
    
    @GetMapping("/pacientes/traerdni/{dni}")
    public Paciente traerPacienteDni (@PathVariable String dni){
        return pacienteServ.findPacienteDni(dni);
    }
    
}
