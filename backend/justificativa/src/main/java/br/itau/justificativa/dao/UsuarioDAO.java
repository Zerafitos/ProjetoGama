package br.itau.justificativa.dao;

import org.springframework.data.repository.CrudRepository;

import br.itau.justificativa.model.Usuario;

public interface UsuarioDAO extends CrudRepository<Usuario, Integer> {
    public Usuario findByRacfAndSenha(String racf, String senha);
            
}
