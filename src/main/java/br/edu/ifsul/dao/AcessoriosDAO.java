package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Acessorios;
import java.io.Serializable;
import javax.ejb.Stateful;

@Stateful
public class AcessoriosDAO <TIPO> extends DAOGenerico<Acessorios> implements Serializable{
    public AcessoriosDAO(){
        super();
        classePensistente = Acessorios.class;
    }
}
