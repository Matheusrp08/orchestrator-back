package orchestrator.dto;

//----------------------------
//Execucao DTO
//----------------------------

import java.time.LocalDateTime;

public class ExecucaoDTO {
 private Long id;
 private Long fluxoId;
 private String status;
 private String inputs;
 private String outputs;
 private String erros;
 private LocalDateTime dataInicio;
 private LocalDateTime dataFim;
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