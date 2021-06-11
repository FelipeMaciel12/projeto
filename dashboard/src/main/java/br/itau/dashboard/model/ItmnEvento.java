package br.itau.dashboard.model;


import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "itmnEvento")
public class ItmnEvento {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numSeq")
    private int numSeq;

   // @Column(name = "dataEvt", nullable = false)
   // private Date dataEvt= new Date();

    @Column(name = "data_evt", nullable =false)
    private LocalDate dataevt;
    
    @OneToOne // um alarme relacionado a um evento
    @JoinColumn (name = "idAlarme")
    @JsonIgnoreProperties("eventos")
    private ItmnAlarme alarme;

    @OneToOne // um equipamento relacionado a um evento
    @JoinColumn (name = "idEquip")
    @JsonIgnoreProperties("eventos")
    private ItmnEquipamento equipamento;

    public int getNumSeq() {
        return numSeq;
    }

    public void setNumSeq(int numSeq) {
        this.numSeq = numSeq;
    }

    public LocalDate getDataevt() {
        return dataevt;
    }

    public void setDataevt(LocalDate dataevt) {
        this.dataevt = dataevt;
    }

    public ItmnAlarme getAlarme() {
        return alarme;
    }

    public void setAlarme(ItmnAlarme alarme) {
        this.alarme = alarme;
    }

    public ItmnEquipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(ItmnEquipamento equipamento) {
        this.equipamento = equipamento;
    }

    
    

}
