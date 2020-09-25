package br.itau.justificativa.dao;

import org.springframework.data.repository.CrudRepository;

import br.itau.justificativa.model.Atividade;

public interface AtividadeDAO extends CrudRepository<Atividade, Integer> {
    
}


