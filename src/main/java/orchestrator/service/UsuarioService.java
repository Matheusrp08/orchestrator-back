package orchestrator.service;

//----------------------------
//Usuario Service
//----------------------------

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import orchestrator.dto.UsuarioDTO;
import orchestrator.entity.Usuario;
import orchestrator.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
 @Autowired
 private UsuarioRepository usuarioRepository;

 public List<UsuarioDTO> findAll() {
     return usuarioRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
 }

 public UsuarioDTO findById(Long id) {
     return usuarioRepository.findById(id).map(this::toDTO).orElse(null);
 }

 public UsuarioDTO save(UsuarioDTO usuarioDTO) {
     Usuario usuario = toEntity(usuarioDTO);
     return toDTO(usuarioRepository.save(usuario));
 }

 public void deleteById(Long id) {
     usuarioRepository.deleteById(id);
 }

 private UsuarioDTO toDTO(Usuario usuario) {
     UsuarioDTO dto = new UsuarioDTO();
     dto.setId(usuario.getId());
     dto.setNome(usuario.getNome());
     dto.setEmail(usuario.getEmail());
     dto.setTenantId(usuario.getTenantId());
     dto.setRole(usuario.getRole());
     dto.setStatus(usuario.getStatus());
     dto.setDataCriacao(usuario.getDataCriacao());
     return dto;
 }

 private Usuario toEntity(UsuarioDTO usuarioDTO) {
     Usuario usuario = new Usuario();
     usuario.setId(usuarioDTO.getId());
     usuario.setNome(usuarioDTO.getNome());
     usuario.setEmail(usuarioDTO.getEmail());
     usuario.setTenantId(usuarioDTO.getTenantId());
     usuario.setRole(usuarioDTO.getRole());
     usuario.setStatus(usuarioDTO.getStatus());
     usuario.setDataCriacao(usuarioDTO.getDataCriacao());
     return usuario;
 }
}