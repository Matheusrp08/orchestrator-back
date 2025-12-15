package orchestrator.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import orchestrator.entity.GitOperation;
import orchestrator.repository.GitOperationRepository;

@Service
public class GitOperationService {
	private final GitOperationRepository gitOperationRepository;

	@Autowired
	public GitOperationService(GitOperationRepository gitOperationRepository) {
		this.gitOperationRepository = gitOperationRepository;
	}

	public List<GitOperation> getAllGitOperations() {
		return gitOperationRepository.findAll();
	}

	public Optional<GitOperation> getGitOperationById(Long id) {
		return gitOperationRepository.findById(id);
	}

	public List<GitOperation> getGitOperationsByWorkspaceId(Long workspaceId) {
		return gitOperationRepository.findByWorkspaceId(workspaceId);
	}

	public List<GitOperation> getGitOperationsByExecucaoId(Long execucaoId) {
		return gitOperationRepository.findByExecucaoId(execucaoId);
	}

	public GitOperation createGitOperation(GitOperation gitOperation) {
		return gitOperationRepository.save(gitOperation);
	}

	public GitOperation updateGitOperation(Long id, GitOperation gitOperation) {
		gitOperation.setId(id);
		return gitOperationRepository.save(gitOperation);
	}

	public void deleteGitOperation(Long id) {
		gitOperationRepository.deleteById(id);
	}
}