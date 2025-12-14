package orchestrator.controller;

//----------------------------
//Agente Controller
//----------------------------

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

import orchestrator.dto.AgenteDTO;
import orchestrator.service.AgenteService;

@RestController
@RequestMapping("/api/agentes")
public class AgenteController {
 @Autowired
 private AgenteService agenteService;

 @GetMapping
 public List<AgenteDTO> getAllAgentes() {
     return agenteService.findAll();
 }

 @GetMapping("/{id}")
 public AgenteDTO getAgenteById(@PathVariable Long id) {
     return agenteService.findById(id);
 }

 @PostMapping
 public AgenteDTO createAgente(@RequestBody AgenteDTO agenteDTO) {
     return agenteService.save(agenteDTO);
 }

 @PutMapping("/{id}")
 public AgenteDTO updateAgente(@PathVariable Long id, @RequestBody AgenteDTO agenteDTO) {
     agenteDTO.setId(id);
     return agenteService.save(agenteDTO);
 }

 @DeleteMapping("/{id}")
 public void deleteAgente(@PathVariable Long id) {
     agenteService.deleteById(id);
 }
}