package orchestrator.service;

//WorkspaceService.java
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import orchestrator.entity.Workspace;
import orchestrator.repository.WorkspaceRepository;

@Service
public class WorkspaceService {
 private final WorkspaceRepository workspaceRepository;

 @Autowired
 public WorkspaceService(WorkspaceRepository workspaceRepository) {
     this.workspaceRepository = workspaceRepository;
 }

 public List<Workspace> getAllWorkspaces() {
     return workspaceRepository.findAll();
 }

 public Optional<Workspace> getWorkspaceById(Long id) {
     return workspaceRepository.findById(id);
 }

 public Workspace createWorkspace(Workspace workspace) {
     return workspaceRepository.save(workspace);
 }

 public Workspace updateWorkspace(Long id, Workspace workspace) {
     workspace.setId(id);
     return workspaceRepository.save(workspace);
 }

 public void deleteWorkspace(Long id) {
     workspaceRepository.deleteById(id);
 }
}