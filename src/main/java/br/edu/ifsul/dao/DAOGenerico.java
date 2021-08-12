package br.edu.ifsul.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class DAOGenerico<TIPO> implements Serializable{
    private List<TIPO> listaObjetos;
    private List<TIPO> listaTodos;
    @PersistenceContext(unitName = "TrabPrimeiraEtapa-WebPU")
    protected EntityManager em;
    protected Class classePensistente;

    public DAOGenerico(){
        
    }
    
    public List<TIPO> getListaObjetos() {
        String jpql = "from " + classePensistente.getSimpleName();
        return em.createQuery(jpql).getResultList();
    }
    
    public List<TIPO> getListaTodos() {
        String jpql = "from " + classePensistente.getSimpleName();
        return em.createQuery(jpql).getResultList();
    }
    
    public void persist(TIPO obj) throws Exception{
        em.persist(obj);
    }
    
    public void merge(TIPO obj) throws Exception{
        em.merge(obj);
    }
    
    public void remover(TIPO obj) throws Exception{
        obj = em.merge(obj);
        em.remove(obj);
    }
    
    public TIPO localizar(Object id) throws Exception{
        return (TIPO) em.find(classePensistente, id);
    }

    public void setListaObjetos(List<TIPO> listaObjetos) {
        this.listaObjetos = listaObjetos;
    }

    public void setListaTodos(List<TIPO> listaTodos) {
        this.listaTodos = listaTodos;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public Class getClassePensistente() {
        return classePensistente;
    }

    public void setClassePensistente(Class classePensistente) {
        this.classePensistente = classePensistente;
    }
}
