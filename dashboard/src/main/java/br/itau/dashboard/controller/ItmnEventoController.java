package br.itau.dashboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.itau.dashboard.model.ItmnEvento;
import br.itau.dashboard.repo.ItmnEventoRepo;

@RestController 
@CrossOrigin("*")
@RequestMapping("/evento")

public class ItmnEventoController {
    
    @Autowired
    private ItmnEventoRepo repo;

    // Buscar todos os eventos
    @GetMapping("/todos")
    public List<ItmnEvento> listarTodos() {

        List<ItmnEvento> lista =  (List<ItmnEvento>) repo.findAll();
        return lista;
    }

    //Filtrar evento por data
    @PostMapping("/data")
    public ResponseEntity<ItmnEvento> buscarEvento(@RequestBody ItmnEvento data){
        ItmnEvento evento = repo.findBydataEvt(data.getDataEvt());
        if (evento!=null) {
            return ResponseEntity.ok(evento); // OK = Codigo 200 (HTTP de sucesso)
        }
        
        return ResponseEntity.notFound().build(); // notFound = Codigo 404 (Não encontrado)
    }

}

