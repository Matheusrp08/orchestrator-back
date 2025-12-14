package orchestrator.dto;

//----------------------------
//Tenant DTO
//----------------------------
import java.time.LocalDateTime;

public class TenantDTO {
	
 private Long id;
 private String nome;
 private String configuracoes;
 private String status;
 private LocalDateTime dataCriacao;

 // Getters and Setters
 public Long getId() {
     return id;
 }

 public void setId(Long id) {
     this.id = id;
 }

 public String getNome() {
     return nome;
 }

 public void setNome(String nome) {
     this.nome = nome;
 }

 public String getConfiguracoes() {
     return configuracoes;
 }

 public void setConfiguracoes(String configuracoes) {
     this.configuracoes = configuracoes;
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
