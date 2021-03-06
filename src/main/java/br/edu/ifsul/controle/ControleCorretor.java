package br.edu.ifsul.controle;

import br.edu.ifsul.dao.CorretorDAO;
import br.edu.ifsul.dao.PessoaDAO;
import br.edu.ifsul.modelo.Corretor;
import br.edu.ifsul.modelo.Pessoa;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named(value = "controleCorretor")
@ViewScoped
public class ControleCorretor implements Serializable{
    
    @EJB
    private CorretorDAO<Corretor> dao;
    private Corretor objeto;
    
    @EJB
    private PessoaDAO<Pessoa> pessoaDAO;
    
    public ControleCorretor(){
        
    }
    
    public String listar(){
        return "/privado/corretor/listar?faces-redirect=true";
    }
    
    public void novo(){
        objeto = new Corretor();
    }
    
    public void alterar(Object id){
        try{
            objeto = dao.localizar(id);
        }catch(Exception e){
            Util.mensagemErro("Erro ao recuperar objeto: " + Util.getMensagemErro(e));
        }
    }
    
    public void excluir(Object id){
        try{
            objeto = dao.localizar(id);
            dao.remover(objeto);
            Util.mensagemInformacao("Objeto removido com sucesso!");
        }catch(Exception e){
            Util.mensagemErro("Erro ao remover objeto: " + Util.getMensagemErro(e));
        }
    }
    
    public void salvar(){
        try{
            if(objeto.getId() == null)
                dao.persist(objeto);
            else
                dao.merge(objeto);
            Util.mensagemInformacao("Objeto persistido com sucesso!");
        }catch(Exception e){
            Util.mensagemErro("Erro ao persistir objeto: " + Util.getMensagemErro(e));
        }
    }

    public CorretorDAO<Corretor> getDao() {
        return dao;
    }

    public void setDao(CorretorDAO<Corretor> dao) {
        this.dao = dao;
    }

    public Corretor getObjeto() {
        return objeto;
    }

    public void setObjeto(Corretor objeto) {
        this.objeto = objeto;
    }

    public PessoaDAO<Pessoa> getPessoaDAO() {
        return pessoaDAO;
    }

    public void setPessoaDAO(PessoaDAO<Pessoa> pessoaDAO) {
        this.pessoaDAO = pessoaDAO;
    }
}