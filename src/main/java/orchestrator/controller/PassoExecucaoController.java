package orchestrator.controller;

//----------------------------
//PassoExecucao Controller
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

import orchestrator.dto.PassoExecucaoDTO;
import orchestrator.service.PassoExecucaoService;

@RestController
@RequestMapping("/api/passo-execucoes")
public class PassoExecucaoController {
 @Autowired
 private PassoExecucaoService passoExecucaoService;

 @GetMapping
 public List<PassoExecucaoDTO> getAllPassoExecucoes() {
     return passoExecucaoService.findAll();
 }

 @GetMapping("/{id}")
 public PassoExecucaoDTO getPassoExecucaoById(@PathVariable Long id) {
     return passoExecucaoService.findById(id);
 }

 @PostMapping
 public PassoExecucaoDTO createPassoExecucao(@RequestBody PassoExecucaoDTO passoExecucaoDTO) {
     return passoExecucaoService.save(passoExecucaoDTO);
 }

 @PutMapping("/{id}")
 public PassoExecucaoDTO updatePassoExecucao(@PathVariable Long id, @RequestBody PassoExecucaoDTO passoExecucaoDTO) {
     passoExecucaoDTO.setId(id);
     return passoExecucaoService.save(passoExecucaoDTO);
 }

 @DeleteMapping("/{id}")
 public void deletePassoExecucao(@PathVariable Long id) {
     passoExecucaoService.deleteById(id);
 }
}