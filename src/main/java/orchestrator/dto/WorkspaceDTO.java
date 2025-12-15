package orchestrator.dto;

import java.time.LocalDateTime;

public class WorkspaceDTO {
	private Long id;
	private Long tenantId;
	private Long agenteId;
	private String tipo;
	private String repositorioUrl;
	private String branchPadrao;
	private String status;
	private LocalDateTime dataCriacao;

	// Getters e Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}

	public Long getAgenteId() {
		return agenteId;
	}

	public void setAgenteId(Long agenteId) {
		this.agenteId = agenteId;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getRepositorioUrl() {
		return repositorioUrl;
	}

	public void setRepositorioUrl(String repositorioUrl) {
		this.repositorioUrl = repositorioUrl;
	}

	public String getBranchPadrao() {
		return branchPadrao;
	}

	public void setBranchPadrao(String branchPadrao) {
		this.branchPadrao = branchPadrao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
}