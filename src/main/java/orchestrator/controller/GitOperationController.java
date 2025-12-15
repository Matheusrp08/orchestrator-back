package orchestrator.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import orchestrator.dto.GitOperationDTO;
import orchestrator.entity.GitOperation;
import orchestrator.service.GitOperationService;

@RestController
@RequestMapping("/api/git-operations")
public class GitOperationController {

    private final GitOperationService gitOperationService;

    @Autowired
    public GitOperationController(GitOperationService gitOperationService) {
        this.gitOperationService = gitOperationService;
    }

    @GetMapping
    public ResponseEntity<List<GitOperationDTO>> getAllGitOperations() {
        List<GitOperation> gitOperations = gitOperationService.getAllGitOperations();
        List<GitOperationDTO> gitOperationDTOs = gitOperations.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(gitOperationDTOs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GitOperationDTO> getGitOperationById(@PathVariable Long id) {
        Optional<GitOperation> gitOperation = gitOperationService.getGitOperationById(id);
        return gitOperation.map(value -> new ResponseEntity<>(convertToDTO(value), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/workspace/{workspaceId}")
    public ResponseEntity<List<GitOperationDTO>> getGitOperationsByWorkspaceId(@PathVariable Long workspaceId) {
        List<GitOperation> gitOperations = gitOperationService.getGitOperationsByWorkspaceId(workspaceId);
        List<GitOperationDTO> gitOperationDTOs = gitOperations.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(gitOperationDTOs, HttpStatus.OK);
    }

    @GetMapping("/execucao/{execucaoId}")
    public ResponseEntity<List<GitOperationDTO>> getGitOperationsByExecucaoId(@PathVariable Long execucaoId) {
        List<GitOperation> gitOperations = gitOperationService.getGitOperationsByExecucaoId(execucaoId);
        List<GitOperationDTO> gitOperationDTOs = gitOperations.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(gitOperationDTOs, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GitOperationDTO> createGitOperation(@RequestBody GitOperationDTO gitOperationDTO) {
        GitOperation gitOperation = convertToEntity(gitOperationDTO);
        GitOperation createdGitOperation = gitOperationService.createGitOperation(gitOperation);
        return new ResponseEntity<>(convertToDTO(createdGitOperation), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GitOperationDTO> updateGitOperation(@PathVariable Long id, @RequestBody GitOperationDTO gitOperationDTO) {
        GitOperation gitOperation = convertToEntity(gitOperationDTO);
        GitOperation updatedGitOperation = gitOperationService.updateGitOperation(id, gitOperation);
        return new ResponseEntity<>(convertToDTO(updatedGitOperation), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGitOperation(@PathVariable Long id) {
        gitOperationService.deleteGitOperation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private GitOperationDTO convertToDTO(GitOperation gitOperation) {
        GitOperationDTO gitOperationDTO = new GitOperationDTO();
        BeanUtils.copyProperties(gitOperation, gitOperationDTO);
        return gitOperationDTO;
    }

    private GitOperation convertToEntity(GitOperationDTO gitOperationDTO) {
        GitOperation gitOperation = new GitOperation();
        BeanUtils.copyProperties(gitOperationDTO, gitOperation);
        return gitOperation;
    }
}