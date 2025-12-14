package orchestrator.controller;

//----------------------------
//LogExecucao Controller
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

import orchestrator.dto.LogExecucaoDTO;
import orchestrator.service.LogExecucaoService;

@RestController
@RequestMapping("/api/log-execucoes")
public class LogExecucaoController {
 @Autowired
 private LogExecucaoService logExecucaoService;

 @GetMapping
 public List<LogExecucaoDTO> getAllLogExecucoes() {
     return logExecucaoService.findAll();
 }

 @GetMapping("/{id}")
 public LogExecucaoDTO getLogExecucaoById(@PathVariable Long id) {
     return logExecucaoService.findById(id);
 }

 @PostMapping
 public LogExecucaoDTO createLogExecucao(@RequestBody LogExecucaoDTO logExecucaoDTO) {
     return logExecucaoService.save(logExecucaoDTO);
 }

 @PutMapping("/{id}")
 public LogExecucaoDTO updateLogExecucao(@PathVariable Long id, @RequestBody LogExecucaoDTO logExecucaoDTO) {
     logExecucaoDTO.setId(id);
     return logExecucaoService.save(logExecucaoDTO);
 }

 @DeleteMapping("/{id}")
 public void deleteLogExecucao(@PathVariable Long id) {
     logExecucaoService.deleteById(id);
 }
}