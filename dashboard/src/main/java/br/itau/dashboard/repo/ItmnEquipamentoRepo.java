package br.itau.dashboard.repo;

import org.springframework.data.repository.CrudRepository;

import br.itau.dashboard.model.ItmnEquipamento;

public interface ItmnEquipamentoRepo extends CrudRepository<ItmnEquipamento,Long> {
    
}
