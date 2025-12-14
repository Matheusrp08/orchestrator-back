package orchestrator.dto;

//----------------------------
//PassoExecucao DTO
//----------------------------

import java.time.LocalDateTime;

public class PassoExecucaoDTO {
 private Long id;
 private Long execucaoId;
 private Long agenteId;
 private Integer ordem;
 private String status;
 private String inputs;
 private String outputs;
 private String erros;
 private LocalDateTime dataInicio;
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