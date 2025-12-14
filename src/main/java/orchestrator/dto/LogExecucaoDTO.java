package orchestrator.dto;

//----------------------------
//LogExecucao DTO
//----------------------------

import java.time.LocalDateTime;

public class LogExecucaoDTO {
 private Long id;
 private Long execucaoId;
 private String nivel;
 private String mensagem;
 private String metadata;
 private LocalDateTime dataCriacao;

 // Getters and Setters
 public Long getId() {
     return id;
 }

 public void setId(Long id) {
     this.id = id;
 }

 public Long getExecucaoId() {
     return execucaoId;
 }

 public void setExecucaoId(Long execucaoId) {
     this.execucaoId = execucaoId;
 }

 public String getNivel() {
     return nivel;
 }

 public void setNivel(String nivel) {
     this.nivel = nivel;
 }

 public String getMensagem() {
     return mensagem;
 }

 public void setMensagem(String mensagem) {
     this.mensagem = mensagem;
 }

 public String getMetadata() {
     return metadata;
 }

 public void setMetadata(String metadata) {
     this.metadata = metadata;
 }

 public LocalDateTime getDataCriacao() {
     return dataCriacao;
 }

 public void setDataCriacao(LocalDateTime dataCriacao) {
     this.dataCriacao = dataCriacao;
 }
}