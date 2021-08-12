package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Pessoa;
import java.io.Serializable;
import javax.ejb.Stateful;

@Stateful
public class PessoaDAO <TIPO> extends DAOGenerico<Pessoa> implements Serializable{
    public PessoaDAO(){
        super();
        classePensistente = Pessoa.class;
    }
}
