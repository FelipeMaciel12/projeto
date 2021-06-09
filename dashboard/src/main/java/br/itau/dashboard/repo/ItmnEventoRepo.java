package br.itau.dashboard.repo;

import java.util.Date;

import org.springframework.data.repository.CrudRepository;

import br.itau.dashboard.model.ItmnEvento;

public interface ItmnEventoRepo extends CrudRepository <ItmnEvento,Long> {

    public ItmnEvento findBydataEvt (Date dataInicio);
    
}
