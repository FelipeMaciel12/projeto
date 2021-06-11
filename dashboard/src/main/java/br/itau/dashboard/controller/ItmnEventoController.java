package br.itau.dashboard.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.fasterxml.jackson.databind.node.ObjectNode;

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
    public ResponseEntity<List<ItmnEvento>> buscarPorData(@RequestBody ObjectNode json) {

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate ini = LocalDate.parse(json.get("dt1").asText(), fmt);
        LocalDate fim = LocalDate.parse(json.get("dt2").asText(), fmt);

        List<ItmnEvento> eventos = repo.findByDataevtBetween(ini, fim);

        return ResponseEntity.ok(eventos);
    }

}

