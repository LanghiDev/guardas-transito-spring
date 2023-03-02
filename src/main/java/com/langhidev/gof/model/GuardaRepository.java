package com.langhidev.gof.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuardaRepository extends CrudRepository<Guarda, String> {

}
