package orchestrator.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import orchestrator.entity.GitOperation;

@Repository
public interface GitOperationRepository extends JpaRepository<GitOperation, Long> {
	List<GitOperation> findByWorkspaceId(Long workspaceId);

	List<GitOperation> findByExecucaoId(Long execucaoId);
}