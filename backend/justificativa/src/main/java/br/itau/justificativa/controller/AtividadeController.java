package br.itau.justificativa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.itau.justificativa.dao.AtividadeDAO;
import br.itau.justificativa.model.Atividade;

@RestController
@CrossOrigin("*")
public class AtividadeController {

    @Autowired
    private AtividadeDAO dao;

    @GetMapping("/atividades")
    public List<Atividade> getMethodName() {
        return (List<Atividade>) dao.findAll();
    }

    
    
}
