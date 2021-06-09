package br.itau.dashboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.itau.dashboard.model.ItmnAlarme;
import br.itau.dashboard.repo.ItmnAlarmeRepo;

@RestController
@CrossOrigin("*")
@RequestMapping("/alarme")

public class ItmnAlarmeController {
    
    @Autowired
    private ItmnAlarmeRepo repo;

    //Buscar todos os alarmes    
    @GetMapping ("/todos")
    public List<ItmnAlarme> listarTodos(){
        List<ItmnAlarme> lista = (List<ItmnAlarme>) repo.findAll();
        return lista;
    }
   
}
