package orchestrator.repository;

//----------------------------
//Fluxo Repository
//----------------------------

import org.springframework.data.jpa.repository.JpaRepository;

import orchestrator.entity.Fluxo;

public interface FluxoRepository extends JpaRepository<Fluxo, Long> {
}