package orchestrator.entity;

//----------------------------
//Execucao Entity
//----------------------------

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "execucao")
public class Execucao {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 @Column(name = "fluxo_id", nullable = false)
 private Long fluxoId;

 @Column(nullable = false)
 private String status;

 @Column(columnDefinition = "JSONB")
 private String inputs;

 @Column(columnDefinition = "JSONB")
 private String outputs;

 @Column(columnDefinition = "JSONB")
 private String erros;

 @Column(name = "data_inicio", nullable = false)
 private LocalDateTime dataInicio;

 @Column(name = "data_fim")
 private LocalDateTime dataFim;

 @Column(name = "tenant_id", nullable = false)
 private Long tenantId;

 // Getters and Setters
 public Long getId() {
     return id;
 }

 public void setId(Long id) {
     this.id = id;
 }

 public Long getFluxoId() {
     return fluxoId;
 }

 public void setFluxoId(Long fluxoId) {
     this.fluxoId = fluxoId;
 }

 public String getStatus() {
     return status;
 }

 public void setStatus(String status) {
     this.status = status;
 }

 public String getInputs() {
     return inputs;
 }

 public void setInputs(String inputs) {
     this.inputs = inputs;
 }

 public String getOutputs() {
     return outputs;
 }

 public void setOutputs(String outputs) {
     this.outputs = outputs;
 }

 public String getErros() {
     return erros;
 }

 public void setErros(String erros) {
     this.erros = erros;
 }

 public LocalDateTime getDataInicio() {
     return dataInicio;
 }

 public void setDataInicio(LocalDateTime dataInicio) {
     this.dataInicio = dataInicio;
 }

 public LocalDateTime getDataFim() {
     return dataFim;
 }

 public void setDataFim(LocalDateTime dataFim) {
     this.dataFim = dataFim;
 }

 public Long getTenantId() {
     return tenantId;
 }

 public void setTenantId(Long tenantId) {
     this.tenantId = tenantId;
 }
}