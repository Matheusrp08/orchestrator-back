package orchestrator.dto;

//----------------------------
//Agente DTO
//----------------------------

import java.time.LocalDateTime;

public class AgenteDTO {
 private Long id;
 private String nome;
 private String versao;
 private String tipo;
 private String configuracoes;
 private String status;
 private LocalDateTime dataCriacao;
 private LocalDateTime dataAtualizacao;
 private Long tenantId;

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

 public String getVersao() {
     return versao;
 }

 public void setVersao(String versao) {
     this.versao = versao;
 }

 public String getTipo() {
     return tipo;
 }

 public void setTipo(String tipo) {
     this.tipo = tipo;
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

 public LocalDateTime getDataAtualizacao() {
     return dataAtualizacao;
 }

 public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
     this.dataAtualizacao = dataAtualizacao;
 }

 public Long getTenantId() {
     return tenantId;
 }

 public void setTenantId(Long tenantId) {
     this.tenantId = tenantId;
 }
}
