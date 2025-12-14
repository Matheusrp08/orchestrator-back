package orchestrator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import orchestrator.entity.Agente;

public interface AgenteRepository extends JpaRepository<Agente, Long> {
}