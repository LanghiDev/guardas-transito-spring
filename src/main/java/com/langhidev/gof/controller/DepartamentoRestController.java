package com.langhidev.gof.controller;

import com.langhidev.gof.model.Departamento;
import com.langhidev.gof.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("departamentos")
public class DepartamentoRestController {

    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping("/")
    public ResponseEntity<Iterable<Departamento>> buscarTodos(){
        return ResponseEntity.ok(departamentoService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Departamento> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(departamentoService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Departamento> inserir(@RequestBody Departamento departamento){
        departamentoService.inserir(departamento);
        return ResponseEntity.ok(departamento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Departamento> atualizar(@PathVariable Long id, @RequestBody Departamento departamento){
        departamentoService.atualizar(id, departamento);
        return ResponseEntity.ok(departamento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        departamentoService.deletar(id);
        return ResponseEntity.ok().build();
    }

}
