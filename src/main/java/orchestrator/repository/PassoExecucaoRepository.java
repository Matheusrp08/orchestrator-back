package orchestrator.repository;

//----------------------------
//PassoExecucao Repository
//----------------------------

import org.springframework.data.jpa.repository.JpaRepository;

import orchestrator.entity.PassoExecucao;

public interface PassoExecucaoRepository extends JpaRepository<PassoExecucao, Long> {
}