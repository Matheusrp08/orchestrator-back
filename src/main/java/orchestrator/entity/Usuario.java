package orchestrator.entity;

//----------------------------
//Usuario Entity
//----------------------------

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 @Column(nullable = false)
 private String nome;

 @Column(nullable = false)
 private String email;

 @Column(name = "tenant_id", nullable = false)
 private Long tenantId;

 @Column(nullable = false)
 private String role;

 @Column(nullable = false)
 private String status;

 @Column(name = "data_criacao", nullable = false)
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

 public String getEmail() {
     return email;
 }

 public void setEmail(String email) {
     this.email = email;
 }

 public Long getTenantId() {
     return tenantId;
 }

 public void setTenantId(Long tenantId) {
     this.tenantId = tenantId;
 }

 public String getRole() {
     return role;
 }

 public void setRole(String role) {
     this.role = role;
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