package orchestrator.service;

//----------------------------
//Execucao Service
//----------------------------

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import orchestrator.dto.ExecucaoDTO;
import orchestrator.entity.Execucao;
import orchestrator.repository.ExecucaoRepository;

@Service
public class ExecucaoService {
 @Autowired
 private ExecucaoRepository execucaoRepository;

 public List<ExecucaoDTO> findAll() {
     return execucaoRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
 }

 public ExecucaoDTO findById(Long id) {
     return execucaoRepository.findById(id).map(this::toDTO).orElse(null);
 }

 public ExecucaoDTO save(ExecucaoDTO execucaoDTO) {
     Execucao execucao = toEntity(execucaoDTO);
     return toDTO(execucaoRepository.save(execucao));
 }

 public void deleteById(Long id) {
     execucaoRepository.deleteById(id);
 }

 private ExecucaoDTO toDTO(Execucao execucao) {
     ExecucaoDTO dto = new ExecucaoDTO();
     dto.setId(execucao.getId());
     dto.setFluxoId(execucao.getFluxoId());
     dto.setStatus(execucao.getStatus());
     dto.setInputs(execucao.getInputs());
     dto.setOutputs(execucao.getOutputs());
     dto.setErros(execucao.getErros());
     dto.setDataInicio(execucao.getDataInicio());
     dto.setDataFim(execucao.getDataFim());
     dto.setTenantId(execucao.getTenantId());
     return dto;
 }

 private Execucao toEntity(ExecucaoDTO execucaoDTO) {
     Execucao execucao = new Execucao();
     execucao.setId(execucaoDTO.getId());
     execucao.setFluxoId(execucaoDTO.getFluxoId());
     execucao.setStatus(execucaoDTO.getStatus());
     execucao.setInputs(execucaoDTO.getInputs());
     execucao.setOutputs(execucaoDTO.getOutputs());
     execucao.setErros(execucaoDTO.getErros());
     execucao.setDataInicio(execucaoDTO.getDataInicio());
     execucao.setDataFim(execucaoDTO.getDataFim());
     execucao.setTenantId(execucaoDTO.getTenantId());
     return execucao;
 }
}