package orchestrator.service;

import java.time.LocalDateTime;

//----------------------------
//Fluxo Service
//----------------------------

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import orchestrator.dto.FluxoDTO;
import orchestrator.entity.Fluxo;
import orchestrator.repository.FluxoRepository;

@Service
public class FluxoService {
    @Autowired
    private FluxoRepository fluxoRepository;

    public List<FluxoDTO> findAll() {
        return fluxoRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public FluxoDTO findById(Long id) {
        return fluxoRepository.findById(id).map(this::toDTO).orElse(null);
    }


    public void deleteById(Long id) {
        fluxoRepository.deleteById(id);
    }
    
    public FluxoDTO save(FluxoDTO fluxoDTO) {
        Fluxo fluxo = toEntity(fluxoDTO);

        // DEFENSIVE NULL CHECKS
        if (fluxo.getDefinicao() == null) {
            fluxo.setDefinicao("{}");
        }
        if (fluxo.getDataCriacao() == null) {
            fluxo.setDataCriacao(LocalDateTime.now());
        }
        if (fluxo.getStatus() == null) {
            fluxo.setStatus("DRAFT"); // Default status
        }

        return toDTO(fluxoRepository.save(fluxo));
    }

    public Fluxo createFluxo(Fluxo fluxo) {
        // COMPREHENSIVE NULL SAFETY
        if (fluxo.getNome() == null) {
            throw new IllegalArgumentException("Nome não pode ser nulo");
        }
        if (fluxo.getVersao() == null) {
            fluxo.setVersao("1.0"); // Default version
        }
        if (fluxo.getDefinicao() == null) {
            fluxo.setDefinicao("{}");
        }
        if (fluxo.getStatus() == null) {
            fluxo.setStatus("DRAFT");
        }
        if (fluxo.getDataCriacao() == null) {
            fluxo.setDataCriacao(LocalDateTime.now());
        }
        if (fluxo.getTenantId() == null) {
            throw new IllegalArgumentException("Tenant ID não pode ser nulo");
        }

        return fluxoRepository.save(fluxo);
    }

    private Fluxo toEntity(FluxoDTO fluxoDTO) {
        Fluxo fluxo = new Fluxo();
        fluxo.setId(fluxoDTO.getId());
        fluxo.setNome(fluxoDTO.getNome());
        fluxo.setVersao(fluxoDTO.getVersao());

        // SAFE MAPPING WITH DEFAULT VALUES
        fluxo.setDefinicao(fluxoDTO.getDefinicao() != null ? fluxoDTO.getDefinicao() : "{}");
        fluxo.setStatus(fluxoDTO.getStatus() != null ? fluxoDTO.getStatus() : "DRAFT");
        fluxo.setDataCriacao(fluxoDTO.getDataCriacao() != null ? fluxoDTO.getDataCriacao() : LocalDateTime.now());
        fluxo.setDataAtualizacao(fluxoDTO.getDataAtualizacao());
        fluxo.setTenantId(fluxoDTO.getTenantId());

        return fluxo;
    }

    private FluxoDTO toDTO(Fluxo fluxo) {
        FluxoDTO dto = new FluxoDTO();
        dto.setId(fluxo.getId());
        dto.setNome(fluxo.getNome());
        dto.setVersao(fluxo.getVersao());
        dto.setDefinicao(fluxo.getDefinicao());
        dto.setStatus(fluxo.getStatus());
        dto.setDataCriacao(fluxo.getDataCriacao());
        dto.setDataAtualizacao(fluxo.getDataAtualizacao());
        dto.setTenantId(fluxo.getTenantId());
        return dto;
    }
}