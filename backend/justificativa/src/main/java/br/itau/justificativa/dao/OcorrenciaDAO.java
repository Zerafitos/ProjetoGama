package br.itau.justificativa.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import br.itau.justificativa.model.Ocorrencia;

public interface OcorrenciaDAO extends CrudRepository<Ocorrencia, Integer> {
    public List<Ocorrencia> findByStatus(int status);
    
    //public List<Ocorrencia> findByStatusAndRacf(int status, String racf);
    //public List<Ocorrencia> findByRacf(String usuario);

    
    //@Query(value="Select new Ocorrencia(o.num_seq, o.descricao) from Ocorrencia o where o.num_seq = :id")
    //public Ocorrencia buscarOcorrenciaPorId(@Param("id") Integer id);
    
    /* @Query(value="Select new Usuario(u.id, u.nome, u.email) from Usuario u Where u.id = :id")
    public Usuario buscarUsuarioPorId(@Param("id") Integer id); */

    
}
