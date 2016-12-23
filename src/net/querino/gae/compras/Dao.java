package net.querino.gae.compras;

import java.util.Date;
import java.util.List;
 
import javax.persistence.EntityManager;
import javax.persistence.Query;
 
public class Dao {
 
  public void incluirConta(String descricao, double valor, Date vencimento, String linhaDigitavel){
    EntityManager em = EMF.get().createEntityManager();
    Conta conta = new Conta(descricao, valor, vencimento, linhaDigitavel);
    em.persist(conta);
    em.close();
  }
 
  public void excluirConta(long id) {
    EntityManager em = EMF.get().createEntityManager();
    try {
      Conta conta = em.find(Conta.class, id);
      em.remove(conta);
    } finally {
      em.close();
    }
 }
 
  public List<Conta> listarContas() {
     EntityManager em = EMF.get().createEntityManager();
    Query q = em.createQuery("select m from Conta m");
    List<Conta> contas = q.getResultList();
    return contas;
  }
}