package com.biblioteca.demo.service.impl;

import com.biblioteca.demo.model.Categorias;
import com.biblioteca.demo.repository.CategoriasRepository;
import com.biblioteca.demo.service.CategoriasService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class CategoriasServiceImpl implements CategoriasService {
        @Autowired
        private CategoriasRepository repoCategorias;

        @Transactional
        @Override
        public Categorias registrarCategorias(Categorias categorias) {
                return repoCategorias.save(categorias);
        }

        @Transactional(readOnly = true)
        @Override
        public List<Categorias> findAll() {
                return repoCategorias.findAll();
        }

        @Transactional(readOnly = true)
        @Override
        public Optional<Categorias> findById(Integer id) {
                return repoCategorias.findById(id);
        }
}
