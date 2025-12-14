package orchestrator.service;

//----------------------------
//Agente Service
//----------------------------

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import orchestrator.dto.AgenteDTO;
import orchestrator.entity.Agente;
import orchestrator.repository.AgenteRepository;

@Service
public class AgenteService {
    @Autowired
    private AgenteRepository agenteRepository;

    public List<AgenteDTO> findAll() {
        return agenteRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public AgenteDTO findById(Long id) {
        return agenteRepository.findById(id).map(this::toDTO).orElse(null);
    }

    public AgenteDTO save(AgenteDTO agenteDTO) {
        Agente agente = toEntity(agenteDTO);
        return toDTO(agenteRepository.save(agente));
    }

    public void deleteById(Long id) {
        agenteRepository.deleteById(id);
    }

    private AgenteDTO toDTO(Agente agente) {
        AgenteDTO dto = new AgenteDTO();
        dto.setId(agente.getId());
        dto.setNome(agente.getNome());
        dto.setVersao(agente.getVersao());
        dto.setTipo(agente.getTipo());
        dto.setConfiguracoes(agente.getConfiguracoes());
        dto.setStatus(agente.getStatus());
        dto.setDataCriacao(agente.getDataCriacao());
        dto.setDataAtualizacao(agente.getDataAtualizacao());
        dto.setTenantId(agente.getTenantId());
        return dto;
    }

    private Agente toEntity(AgenteDTO agenteDTO) {
        Agente agente = new Agente();
        agente.setId(agenteDTO.getId());
        agente.setNome(agenteDTO.getNome());
        agente.setVersao(agenteDTO.getVersao());
        agente.setTipo(agenteDTO.getTipo());
        agente.setConfiguracoes(agenteDTO.getConfiguracoes());
        agente.setStatus(agenteDTO.getStatus());
        agente.setDataCriacao(agenteDTO.getDataCriacao());
        agente.setDataAtualizacao(agenteDTO.getDataAtualizacao());
        agente.setTenantId(agenteDTO.getTenantId());
        return agente;
    }
}