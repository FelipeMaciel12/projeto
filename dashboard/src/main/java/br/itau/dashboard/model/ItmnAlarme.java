package br.itau.dashboard.model;

//import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.OneToMany;
import javax.persistence.Table;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name="itmnAlarme")
public class ItmnAlarme {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="idAlarme")
    private int idAlarme;

    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "descricao", length = 200, nullable = false)
    private String descricao;

   // @OneToMany(mappedBy = "alarme") // um alarme para vários eventos
   // @JsonIgnoreProperties("alarme")
   // private List <ItmnEvento> eventos;

    public int getIdAlarme() {
        return idAlarme;
    }

    public void setIdAlarme(int idAlarme) {
        this.idAlarme = idAlarme;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    //public List<ItmnEvento> getEventos() {
    //    return eventos;
    //}

    //public void setEventos(List<ItmnEvento> eventos) {
    //    this.eventos = eventos;
    //}

    
}
