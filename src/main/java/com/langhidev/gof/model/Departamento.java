package com.langhidev.gof.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nomeLocal;
    @ManyToOne
    private Endereco endereco;

    @ElementCollection
    @CollectionTable(name = "listaDeDepartamento")
    private List<Guarda> guardas = new ArrayList<Guarda>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeLocal() {
        return nomeLocal;
    }

    public void setNomeLocal(String nomeLocal) {
        this.nomeLocal = nomeLocal;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Guarda> getGuardas() {
        return guardas;
    }

    public void setGuardas(List<Guarda> guardas) {
        this.guardas = guardas;
    }
}
