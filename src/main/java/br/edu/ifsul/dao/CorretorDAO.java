package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Corretor;
import java.io.Serializable;
import javax.ejb.Stateful;

@Stateful
public class CorretorDAO <TIPO> extends DAOGenerico<Corretor> implements Serializable{
    public CorretorDAO(){
        super();
        classePensistente = Corretor.class;
    }
}