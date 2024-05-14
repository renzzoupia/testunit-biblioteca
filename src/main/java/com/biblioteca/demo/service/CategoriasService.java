package com.biblioteca.demo.service;

import com.biblioteca.demo.model.Categorias;
import java.util.List;
import java.util.Optional;

public interface CategoriasService {
        public Categorias registrarCategorias(Categorias categorias);

        public List<Categorias> findAll();

        public Optional<Categorias> findById(Integer id);
}
