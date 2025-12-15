package orchestrator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import orchestrator.entity.Workspace;

@Repository
public interface WorkspaceRepository extends JpaRepository<Workspace, Long> {
}