package com.langhidev.gof.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Guarda {

    @Id
    private String nomeGuarda;
    private String horaEntrada;
    private String horaSaida;
    private String local;

    public String getNomeGuarda() {
        return nomeGuarda;
    }

    public void setNomeGuarda(String nomeGuarda) {
        this.nomeGuarda = nomeGuarda;
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
