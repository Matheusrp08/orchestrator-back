package orchestrator.entity;

//----------------------------
//PassoExecucao Entity
//----------------------------

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "passo_execucao")
public class PassoExecucao {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 @Column(name = "execucao_id", nullable = false)
 private Long execucaoId;

 @Column(name = "agente_id", nullable = false)
 private Long agenteId;

 @Column(nullable = false)
 private Integer ordem;

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

 public Long getAgenteId() {
     return agenteId;
 }

 public void setAgenteId(Long agenteId) {
     this.agenteId = agenteId;
 }

 public Integer getOrdem() {
     return ordem;
 }

 public void setOrdem(Integer ordem) {
     this.ordem = ordem;
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
}

