package orchestrator.controller;

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

import orchestrator.dto.TenantDTO;
import orchestrator.service.TenantService;

@RestController
@RequestMapping("/api/tenants")
public class TenantController {
    @Autowired
    private TenantService tenantService;

    @GetMapping
    public List<TenantDTO> getAllTenants() {
        return tenantService.findAll();
    }

    @GetMapping("/{id}")
    public TenantDTO getTenantById(@PathVariable Long id) {
        return tenantService.findById(id);
    }

    @PostMapping
    public TenantDTO createTenant(@RequestBody TenantDTO tenantDTO) {
        return tenantService.save(tenantDTO);
    }

    @PutMapping("/{id}")
    public TenantDTO updateTenant(@PathVariable Long id, @RequestBody TenantDTO tenantDTO) {
        tenantDTO.setId(id);
        return tenantService.save(tenantDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteTenant(@PathVariable Long id) {
        tenantService.deleteById(id);
    }
}