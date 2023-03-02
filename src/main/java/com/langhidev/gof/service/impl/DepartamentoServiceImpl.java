package com.langhidev.gof.service.impl;

import com.langhidev.gof.model.*;
import com.langhidev.gof.service.DepartamentoService;
import com.langhidev.gof.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;
    @Autowired
    private GuardaRepository guardaRepository;

    @Override
    public Iterable<Departamento> buscarTodos() {
        // Buscar todos os departamentos
        return departamentoRepository.findAll();
    }

    @Override
    public Departamento buscarPorId(Long id) {
        Optional<Departamento> departamento = departamentoRepository.findById(id);
        return departamento.get();
    }

    @Override
    public void inserir(Departamento departamento) {
        salvarDepartamentoComAtributos(departamento);
    }

    @Override
    public void atualizar(Long id, Departamento departamento) {
        // Buscar departamento por ID, caso exista:
        Optional<Departamento> departamentoBd = departamentoRepository.findById(id);
        if(departamentoBd.isPresent()){
            salvarDepartamentoComAtributos(departamento);
        }
    }

    @Override
    public void deletar(Long id) {
        // Deletar departamento por ID
        departamentoRepository.deleteById(id);
    }

    private void salvarDepartamentoComAtributos(Departamento departamento){
        // Verifica se o Endereço do Departamento já existe (pelo CEP)
        String cep = departamento.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            // Caso não exista, integrar com o ViaCEP e persistir o retorno
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        // Vinculando o Endereco (novo ou existente) ao departamento
        departamento.setEndereco(endereco);

        // Vinculando os Guardas ao departamento
        List<Guarda> guardas = new ArrayList<Guarda>();
        for (Guarda guardaDep : departamento.getGuardas()) {
            String nome = guardaDep.getNome();
            Guarda guarda = guardaRepository.findById(nome).orElseGet(() -> {
                guardaRepository.save(guardaDep);
                return guardaDep;
            });
            guardas.add(guarda);
        }
        departamento.setGuardas(guardas);

        departamentoRepository.save(departamento);
    }


}
