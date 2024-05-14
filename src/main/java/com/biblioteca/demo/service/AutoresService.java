package com.biblioteca.demo.service;

import com.biblioteca.demo.model.Autores;
import java.util.List;
import java.util.Optional;

public interface AutoresService {
        public Autores registrarAutores(Autores autores);

        public List<Autores> findAll();

        public Optional<Autores> findById(Integer id);
}
