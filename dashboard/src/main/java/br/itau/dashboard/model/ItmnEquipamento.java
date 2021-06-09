package br.itau.dashboard.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name = "itmnEquipamento")

public class ItmnEquipamento {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name="idEquip")
    private int idEquip;
    
    @Column(name = "hostname", length = 50, nullable = false)
    private String hostname;

    @Column(name = "ipaddr", length = 15, nullable = false)
    private String ipaddr;

    @OneToMany(mappedBy = "equipamento") // um equipamento para vários eventos
    @JsonIgnoreProperties("equipamento")
    private List <ItmnEvento> eventos;

    public int getIdEquip() {
        return idEquip;
    }

    public void setIdEquip(int idEquip) {
        this.idEquip = idEquip;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getIpaddr() {
        return ipaddr;
    }

    public void setIpaddr(String ipaddr) {
        this.ipaddr = ipaddr;
    }

    public List<ItmnEvento> getEventos() {
        return eventos;
    }

    public void setEventos(List<ItmnEvento> eventos) {
        this.eventos = eventos;
    }    

}