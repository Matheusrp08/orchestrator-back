package orchestrator.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "git_operation")
public class GitOperation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "workspace_id", nullable = false)
	private Long workspaceId;

	@Column(name = "execucao_id")
	private Long execucaoId;

	@Column(name = "operacao_tipo", nullable = false, length = 50)
	private String operacaoTipo;

	@Column(name = "arquivo_caminho")
	private String arquivoCaminho;

	@Column(name = "commit_mensagem")
	private String commitMensagem;

	@Column(length = 100)
	private String branch;

	@Column(nullable = false, length = 50)
	private String status;

	@Column(name = "hash_resultante", length = 40)
	private String hashResultante;

	@Column(name = "data_operacao", nullable = false)
	private LocalDateTime dataOperacao;

	// Getters e Setters
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
}