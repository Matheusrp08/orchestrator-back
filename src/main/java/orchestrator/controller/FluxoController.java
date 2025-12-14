package orchestrator.controller;

//----------------------------
//Fluxo Controller
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

import orchestrator.dto.FluxoDTO;
import orchestrator.service.FluxoService;

@RestController
@RequestMapping("/api/fluxos")
public class FluxoController {
 @Autowired
 private FluxoService fluxoService;

 @GetMapping
 public List<FluxoDTO> getAllFluxos() {
     return fluxoService.findAll();
 }

 @GetMapping("/{id}")
 public FluxoDTO getFluxoById(@PathVariable Long id) {
     return fluxoService.findById(id);
 }

 @PostMapping
 public FluxoDTO createFluxo(@RequestBody FluxoDTO fluxoDTO) {
     return fluxoService.save(fluxoDTO);
 }

 @PutMapping("/{id}")
 public FluxoDTO updateFluxo(@PathVariable Long id, @RequestBody FluxoDTO fluxoDTO) {
     fluxoDTO.setId(id);
     return fluxoService.save(fluxoDTO);
 }

 @DeleteMapping("/{id}")
 public void deleteFluxo(@PathVariable Long id) {
     fluxoService.deleteById(id);
 }
}