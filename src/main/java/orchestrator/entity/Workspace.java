package orchestrator.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "workspace")
public class Workspace {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "tenant_id", nullable = false)
	private Long tenantId;

	@Column(name = "agente_id", nullable = false)
	private Long agenteId;

	@Column(nullable = false)
	private String tipo;

	@Column(name = "repositorio_url", nullable = false, length = 512)
	private String repositorioUrl;

	@Column(name = "branch_padrao", nullable = false, length = 100)
	private String branchPadrao;

	@Column(nullable = false)
	private String status;

	@Column(name = "data_criacao", nullable = false)
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