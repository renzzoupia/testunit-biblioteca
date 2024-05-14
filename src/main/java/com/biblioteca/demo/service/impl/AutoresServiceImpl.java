package com.biblioteca.demo.service.impl;

import com.biblioteca.demo.model.Autores;
import com.biblioteca.demo.repository.AutoresRepository;
import com.biblioteca.demo.service.AutoresService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class AutoresServiceImpl implements AutoresService {
        @Autowired
        private AutoresRepository repoAutores;

        @Transactional
        @Override
        public Autores registrarAutores(Autores autores) {
                return repoAutores.save(autores);
        }

        @Transactional(readOnly = true)
        @Override
        public List<Autores> findAll() {
                return repoAutores.findAll();
        }

        @Transactional(readOnly = true)
        @Override
        public Optional<Autores> findById(Integer id) {
                return repoAutores.findById(id);
        }
}
