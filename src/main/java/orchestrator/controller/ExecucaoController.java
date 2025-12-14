package orchestrator.controller;

//----------------------------
//Execucao Controller
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

import orchestrator.dto.ExecucaoDTO;
import orchestrator.service.ExecucaoService;

@RestController
@RequestMapping("/api/execucoes")
public class ExecucaoController {
 @Autowired
 private ExecucaoService execucaoService;

 @GetMapping
 public List<ExecucaoDTO> getAllExecucoes() {
     return execucaoService.findAll();
 }

 @GetMapping("/{id}")
 public ExecucaoDTO getExecucaoById(@PathVariable Long id) {
     return execucaoService.findById(id);
 }

 @PostMapping
 public ExecucaoDTO createExecucao(@RequestBody ExecucaoDTO execucaoDTO) {
     return execucaoService.save(execucaoDTO);
 }

 @PutMapping("/{id}")
 public ExecucaoDTO updateExecucao(@PathVariable Long id, @RequestBody ExecucaoDTO execucaoDTO) {
     execucaoDTO.setId(id);
     return execucaoService.save(execucaoDTO);
 }

 @DeleteMapping("/{id}")
 public void deleteExecucao(@PathVariable Long id) {
     execucaoService.deleteById(id);
 }
}