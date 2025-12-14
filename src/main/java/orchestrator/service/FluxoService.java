package orchestrator.service;

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

    public FluxoDTO save(FluxoDTO fluxoDTO) {
        Fluxo fluxo = toEntity(fluxoDTO);
        return toDTO(fluxoRepository.save(fluxo));
    }

    public void deleteById(Long id) {
        fluxoRepository.deleteById(id);
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

    private Fluxo toEntity(FluxoDTO fluxoDTO) {
        Fluxo fluxo = new Fluxo();
        fluxo.setId(fluxoDTO.getId());
        fluxo.setNome(fluxoDTO.getNome());
        fluxo.setVersao(fluxoDTO.getVersao());
        fluxo.setDefinicao(fluxoDTO.getDefinicao());
        fluxo.setStatus(fluxoDTO.getStatus());
        fluxo.setDataCriacao(fluxoDTO.getDataCriacao());
        fluxo.setDataAtualizacao(fluxoDTO.getDataAtualizacao());
        fluxo.setTenantId(fluxoDTO.getTenantId());
        return fluxo;
    }
}