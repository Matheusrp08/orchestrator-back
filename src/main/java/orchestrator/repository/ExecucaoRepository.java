package orchestrator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import orchestrator.entity.Execucao;

public interface ExecucaoRepository extends JpaRepository<Execucao, Long> {
}
