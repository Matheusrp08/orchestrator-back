package orchestrator.entity;

//----------------------------
//Fluxo Entity
//----------------------------

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "fluxo")
public class Fluxo {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 @Column(nullable = false)
 private String nome;

 @Column(nullable = false)
 private String versao;

 @Column(columnDefinition = "JSONB", nullable = false)
 private String definicao;

 @Column(nullable = false)
 private String status;

 @Column(nullable = false)
 private LocalDateTime dataCriacao;

 @Column
 private LocalDateTime dataAtualizacao;

 @Column(nullable = false)
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

 public String getDefinicao() {
     return definicao;
 }

 public void setDefinicao(String definicao) {
     this.definicao = definicao;
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