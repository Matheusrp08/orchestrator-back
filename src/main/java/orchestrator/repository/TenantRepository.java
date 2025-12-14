package orchestrator.repository;

//----------------------------
//Tenant Repository
//----------------------------
import org.springframework.data.jpa.repository.JpaRepository;

import orchestrator.entity.Tenant;

public interface TenantRepository extends JpaRepository<Tenant, Long> {
	
}