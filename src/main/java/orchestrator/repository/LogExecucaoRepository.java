package orchestrator.repository;


//----------------------------
//LogExecucao Repository
//----------------------------

import org.springframework.data.jpa.repository.JpaRepository;

import orchestrator.entity.LogExecucao;

public interface LogExecucaoRepository extends JpaRepository<LogExecucao, Long> {
}