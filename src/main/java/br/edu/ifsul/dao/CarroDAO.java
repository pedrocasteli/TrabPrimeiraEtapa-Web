package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Carro;
import java.io.Serializable;

public class CarroDAO <TIPO> extends DAOGenerico<Carro> implements Serializable{
    public CarroDAO(){
        super();
        classePensistente = Carro.class;
    }
}