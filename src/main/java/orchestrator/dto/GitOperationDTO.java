package orchestrator.dto;

//GitOperationDTO.java
import java.time.LocalDateTime;

public class GitOperationDTO {
	private Long id;
	private Long workspaceId;
	private Long execucaoId;
	private String operacaoTipo;
	private String arquivoCaminho;
	private String commitMensagem;
	private String branch;
	private String status;
	private String hashResultante;
	private LocalDateTime dataOperacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getWorkspaceId() {
		return workspaceId;
	}

	public void setWorkspaceId(Long workspaceId) {
		this.workspaceId = workspaceId;
	}

	public Long getExecucaoId() {
		return execucaoId;
	}

	public void setExecucaoId(Long execucaoId) {
		this.execucaoId = execucaoId;
	}

	public String getOperacaoTipo() {
		return operacaoTipo;
	}

	public void setOperacaoTipo(String operacaoTipo) {
		this.operacaoTipo = operacaoTipo;
	}

	public String getArquivoCaminho() {
		return arquivoCaminho;
	}

	public void setArquivoCaminho(String arquivoCaminho) {
		this.arquivoCaminho = arquivoCaminho;
	}

	public String getCommitMensagem() {
		return commitMensagem;
	}

	public void setCommitMensagem(String commitMensagem) {
		this.commitMensagem = commitMensagem;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getHashResultante() {
		return hashResultante;
	}

	public void setHashResultante(String hashResultante) {
		this.hashResultante = hashResultante;
	}

	public LocalDateTime getDataOperacao() {
		return dataOperacao;
	}

	public void setDataOperacao(LocalDateTime dataOperacao) {
		this.dataOperacao = dataOperacao;
	}

	// Getters e Setters
}