package br.itau.dashboard.repo;

import java.time.LocalDate;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.itau.dashboard.model.ItmnEvento;

public interface ItmnEventoRepo extends CrudRepository<ItmnEvento, Integer> {
    public List<ItmnEvento> findByDataevtBetween(LocalDate dataInicio, LocalDate dataFim);
}
