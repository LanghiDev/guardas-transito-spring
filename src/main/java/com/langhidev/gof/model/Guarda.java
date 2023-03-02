package com.langhidev.gof.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Guarda {

    @Id
    private String nome;
    private String horaEntrada;
    private String horaSaida;
    private String local;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(String horaSaida) {
        this.horaSaida = horaSaida;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
}
