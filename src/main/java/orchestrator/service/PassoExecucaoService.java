package orchestrator.service;

//----------------------------
//PassoExecucao Service
//----------------------------

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import orchestrator.dto.PassoExecucaoDTO;
import orchestrator.entity.PassoExecucao;
import orchestrator.repository.PassoExecucaoRepository;

@Service
public class PassoExecucaoService {
 @Autowired
 private PassoExecucaoRepository passoExecucaoRepository;

 public List<PassoExecucaoDTO> findAll() {
     return passoExecucaoRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
 }

 public PassoExecucaoDTO findById(Long id) {
     return passoExecucaoRepository.findById(id).map(this::toDTO).orElse(null);
 }

 public PassoExecucaoDTO save(PassoExecucaoDTO passoExecucaoDTO) {
     PassoExecucao passoExecucao = toEntity(passoExecucaoDTO);
     return toDTO(passoExecucaoRepository.save(passoExecucao));
 }

 public void deleteById(Long id) {
     passoExecucaoRepository.deleteById(id);
 }

 private PassoExecucaoDTO toDTO(PassoExecucao passoExecucao) {
     PassoExecucaoDTO dto = new PassoExecucaoDTO();
     dto.setId(passoExecucao.getId());
     dto.setExecucaoId(passoExecucao.getExecucaoId());
     dto.setAgenteId(passoExecucao.getAgenteId());
     dto.setOrdem(passoExecucao.getOrdem());
     dto.setStatus(passoExecucao.getStatus());
     dto.setInputs(passoExecucao.getInputs());
     dto.setOutputs(passoExecucao.getOutputs());
     dto.setErros(passoExecucao.getErros());
     dto.setDataInicio(passoExecucao.getDataInicio());
     dto.setDataFim(passoExecucao.getDataFim());
     return dto;
 }

 private PassoExecucao toEntity(PassoExecucaoDTO passoExecucaoDTO) {
     PassoExecucao passoExecucao = new PassoExecucao();
     passoExecucao.setId(passoExecucaoDTO.getId());
     passoExecucao.setExecucaoId(passoExecucaoDTO.getExecucaoId());
     passoExecucao.setAgenteId(passoExecucaoDTO.getAgenteId());
     passoExecucao.setOrdem(passoExecucaoDTO.getOrdem());
     passoExecucao.setStatus(passoExecucaoDTO.getStatus());
     passoExecucao.setInputs(passoExecucaoDTO.getInputs());
     passoExecucao.setOutputs(passoExecucaoDTO.getOutputs());
     passoExecucao.setErros(passoExecucaoDTO.getErros());
     passoExecucao.setDataInicio(passoExecucaoDTO.getDataInicio());
     passoExecucao.setDataFim(passoExecucaoDTO.getDataFim());
     return passoExecucao;
 }
}