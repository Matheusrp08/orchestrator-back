package orchestrator.service;

//----------------------------
//LogExecucao Service
//----------------------------

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import orchestrator.dto.LogExecucaoDTO;
import orchestrator.entity.LogExecucao;
import orchestrator.repository.LogExecucaoRepository;

@Service
public class LogExecucaoService {
 @Autowired
 private LogExecucaoRepository logExecucaoRepository;

 public List<LogExecucaoDTO> findAll() {
     return logExecucaoRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
 }

 public LogExecucaoDTO findById(Long id) {
     return logExecucaoRepository.findById(id).map(this::toDTO).orElse(null);
 }

 public LogExecucaoDTO save(LogExecucaoDTO logExecucaoDTO) {
     LogExecucao logExecucao = toEntity(logExecucaoDTO);
     return toDTO(logExecucaoRepository.save(logExecucao));
 }

 public void deleteById(Long id) {
     logExecucaoRepository.deleteById(id);
 }

 private LogExecucaoDTO toDTO(LogExecucao logExecucao) {
     LogExecucaoDTO dto = new LogExecucaoDTO();
     dto.setId(logExecucao.getId());
     dto.setExecucaoId(logExecucao.getExecucaoId());
     dto.setNivel(logExecucao.getNivel());
     dto.setMensagem(logExecucao.getMensagem());
     dto.setMetadata(logExecucao.getMetadata());
     dto.setDataCriacao(logExecucao.getDataCriacao());
     return dto;
 }

 private LogExecucao toEntity(LogExecucaoDTO logExecucaoDTO) {
     LogExecucao logExecucao = new LogExecucao();
     logExecucao.setId(logExecucaoDTO.getId());
     logExecucao.setExecucaoId(logExecucaoDTO.getExecucaoId());
     logExecucao.setNivel(logExecucaoDTO.getNivel());
     logExecucao.setMensagem(logExecucaoDTO.getMensagem());
     logExecucao.setMetadata(logExecucaoDTO.getMetadata());
     logExecucao.setDataCriacao(logExecucaoDTO.getDataCriacao());
     return logExecucao;
 }
}