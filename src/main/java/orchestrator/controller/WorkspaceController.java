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

import orchestrator.dto.WorkspaceDTO;
import orchestrator.entity.Workspace;
import orchestrator.service.WorkspaceService;

@RestController
@RequestMapping("/api/workspaces")
public class WorkspaceController {

    private final WorkspaceService workspaceService;

    @Autowired
    public WorkspaceController(WorkspaceService workspaceService) {
        this.workspaceService = workspaceService;
    }

    @GetMapping
    public ResponseEntity<List<WorkspaceDTO>> getAllWorkspaces() {
        List<Workspace> workspaces = workspaceService.getAllWorkspaces();
        List<WorkspaceDTO> workspaceDTOs = workspaces.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(workspaceDTOs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkspaceDTO> getWorkspaceById(@PathVariable Long id) {
        Optional<Workspace> workspace = workspaceService.getWorkspaceById(id);
        return workspace.map(value -> new ResponseEntity<>(convertToDTO(value), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<WorkspaceDTO> createWorkspace(@RequestBody WorkspaceDTO workspaceDTO) {
        Workspace workspace = convertToEntity(workspaceDTO);
        Workspace createdWorkspace = workspaceService.createWorkspace(workspace);
        return new ResponseEntity<>(convertToDTO(createdWorkspace), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkspaceDTO> updateWorkspace(@PathVariable Long id, @RequestBody WorkspaceDTO workspaceDTO) {
        Workspace workspace = convertToEntity(workspaceDTO);
        Workspace updatedWorkspace = workspaceService.updateWorkspace(id, workspace);
        return new ResponseEntity<>(convertToDTO(updatedWorkspace), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkspace(@PathVariable Long id) {
        workspaceService.deleteWorkspace(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private WorkspaceDTO convertToDTO(Workspace workspace) {
        WorkspaceDTO workspaceDTO = new WorkspaceDTO();
        BeanUtils.copyProperties(workspace, workspaceDTO);
        return workspaceDTO;
    }

    private Workspace convertToEntity(WorkspaceDTO workspaceDTO) {
        Workspace workspace = new Workspace();
        BeanUtils.copyProperties(workspaceDTO, workspace);
        return workspace;
    }
}