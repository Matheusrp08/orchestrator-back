package orchestrator.controller;

//----------------------------
//Usuario Controller
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

import orchestrator.dto.UsuarioDTO;
import orchestrator.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
 @Autowired
 private UsuarioService usuarioService;

 @GetMapping
 public List<UsuarioDTO> getAllUsuarios() {
     return usuarioService.findAll();
 }

 @GetMapping("/{id}")
 public UsuarioDTO getUsuarioById(@PathVariable Long id) {
     return usuarioService.findById(id);
 }

 @PostMapping
 public UsuarioDTO createUsuario(@RequestBody UsuarioDTO usuarioDTO) {
     return usuarioService.save(usuarioDTO);
 }

 @PutMapping("/{id}")
 public UsuarioDTO updateUsuario(@PathVariable Long id, @RequestBody UsuarioDTO usuarioDTO) {
     usuarioDTO.setId(id);
     return usuarioService.save(usuarioDTO);
 }

 @DeleteMapping("/{id}")
 public void deleteUsuario(@PathVariable Long id) {
     usuarioService.deleteById(id);
 }
}