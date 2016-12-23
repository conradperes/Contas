package net.querino.gae.compras;

import java.util.Date;
import javax.persistence.*;
 
@Entity
public class Conta {
      
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String descricao;
  private double valor;
  private Date vencimento;
  private String linhadigitavel;
 
  public Conta(String descricao, double valor, Date vencimento, String linhadigitavel) {
    this.descricao = descricao;
    this.valor = valor;
    this.vencimento = vencimento;
    this.linhadigitavel = linhadigitavel;
  }
 
  public Long getId() {
    return id;
  }
 
  public String getDescricao() {
    return descricao;
  }
 
  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }
 
  public double getValor() {
    return valor;
  }
 
  public void setValor(double valor) {
    this.valor = valor;
  }
 
  public Date getVencimento() {
    return vencimento;
  }
 
  public void setVencimento(Date vencimento) {
    this.vencimento = vencimento;
  }
 
  public String getLinhadigitavel() {
    return linhadigitavel;
  }
 
  public void setLinhadigitavel(String linhadigitavel) {
    this.linhadigitavel = linhadigitavel;
  }
 
}
