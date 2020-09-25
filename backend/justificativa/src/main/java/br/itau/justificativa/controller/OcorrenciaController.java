package br.itau.justificativa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.itau.justificativa.dao.OcorrenciaDAO;
import br.itau.justificativa.model.Ocorrencia;


@RestController
@CrossOrigin("*")
public class OcorrenciaController {
    @Autowired
    private OcorrenciaDAO dao;

    @GetMapping("/ocorrencias")
    public List<Ocorrencia> getMethodName() {
        return (List<Ocorrencia>) dao.findAll();
    }

   /*  @GetMapping("/ocorrencias/usuario")
    public List<Ocorrencia> buscarOcorrenciasPorUsuario(@PathVariable String racf){
        Usuario usuario = new Usuario(racf);
        List<Ocorrencia> ocorrencias = dao.findByStatusAndRacf(0, usuario);
        return ocorrencias;
     }  */

     @GetMapping("/ocorrencias/status/{id}")
    public List<Ocorrencia> buscarOcorrenciaPorStatus(@PathVariable int id) {
        List<Ocorrencia> ocorrencia = (List<Ocorrencia>)dao.findByStatus(id);
        return ocorrencia;
    }
    
    @GetMapping("ocorrencia/{id}")
    public ResponseEntity<Ocorrencia> buscaOcorrenciaPorId(@PathVariable int id) {
        Ocorrencia ocorrencia = dao.findById(id).orElse(null);
        if(ocorrencia != null) {
            return ResponseEntity.ok(ocorrencia);
        } else {
            return ResponseEntity.status(404).build();
        }
        
    }

    @PostMapping("/ocorrencia/update")
    public ResponseEntity<Ocorrencia> updateOcorrencia(@RequestBody Ocorrencia ocorrencia) {
        Ocorrencia novo = dao.save(ocorrencia);

        return ResponseEntity.ok(novo);
    }


    /* @GetMapping("/usuario/nativo/{id}")
    public ResponseEntity<Object[]> buscarPorIdNativo(@PathVariable int id) {
        Object[] usuario = dao.buscarUsuarioPorIdNativo(id);
        
        if(usuario != null){
            return ResponseEntity.ok(usuario);
        }else{
            return ResponseEntity.status(404).build();
        }
    } */

    

    /* @PostMapping("/ocorrencia/atualizar")
    public ResponseEntity<Ocorrencia> atualizarOcorrencia(@RequestBody Ocorrencia ocorrencia) {
        Ocorrencia atualizaOcorrencia = dao.save(ocorrencia.setDescricao());
        if(atualizarOcorrencia != null) {
            return ResponseEntity.ok(atualizarOcorrencia);
        }
        return ResponseEntity.badRequest().build();
    } */
    
    
}
