package com.langhidev.gof.service;

import com.langhidev.gof.model.Departamento;

public interface DepartamentoService {

    Iterable<Departamento> buscarTodos();

    Departamento buscarPorId(Long id);

    void inserir(Departamento departamento);

    void atualizar(Long id, Departamento departamento);

    void deletar(Long id);


}
