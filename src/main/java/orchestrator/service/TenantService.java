package orchestrator.service;

//----------------------------
//Tenant Service
//----------------------------

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import orchestrator.dto.TenantDTO;
import orchestrator.entity.Tenant;
import orchestrator.repository.TenantRepository;

@Service
public class TenantService {
 @Autowired
 private TenantRepository tenantRepository;

 public List<TenantDTO> findAll() {
     return tenantRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
 }

 public TenantDTO findById(Long id) {
     return tenantRepository.findById(id).map(this::toDTO).orElse(null);
 }

 public TenantDTO save(TenantDTO tenantDTO) {
     Tenant tenant = toEntity(tenantDTO);
     return toDTO(tenantRepository.save(tenant));
 }

 public void deleteById(Long id) {
     tenantRepository.deleteById(id);
 }

 private TenantDTO toDTO(Tenant tenant) {
     TenantDTO dto = new TenantDTO();
     dto.setId(tenant.getId());
     dto.setNome(tenant.getNome());
     dto.setConfiguracoes(tenant.getConfiguracoes());
     dto.setStatus(tenant.getStatus());
     dto.setDataCriacao(tenant.getDataCriacao());
     return dto;
 }

 private Tenant toEntity(TenantDTO tenantDTO) {
     Tenant tenant = new Tenant();
     tenant.setId(tenantDTO.getId());
     tenant.setNome(tenantDTO.getNome());
     tenant.setConfiguracoes(tenantDTO.getConfiguracoes());
     tenant.setStatus(tenantDTO.getStatus());
     tenant.setDataCriacao(tenantDTO.getDataCriacao());
     return tenant;
 }
}