package orchestrator.entity;

//----------------------------
//LogExecucao Entity
//----------------------------

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "log_execucao")
public class LogExecucao {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 @Column(name = "execucao_id", nullable = false)
 private Long execucaoId;

 @Column(nullable = false)
 private String nivel;

 @Column(nullable = false, columnDefinition = "TEXT")
 private String mensagem;

 @Column(columnDefinition = "JSONB")
 private String metadata;

 @Column(name = "data_criacao", nullable = false)
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