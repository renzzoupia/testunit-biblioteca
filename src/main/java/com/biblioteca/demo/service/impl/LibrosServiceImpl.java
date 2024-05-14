package com.biblioteca.demo.service.impl;

import com.biblioteca.demo.model.Libros;
import com.biblioteca.demo.repository.LibrosRepository;
import com.biblioteca.demo.service.LibrosService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class LibrosServiceImpl implements LibrosService {
        @Autowired
        private LibrosRepository repoLibros;

        @Transactional
        @Override
        public Libros registrarLibros(Libros Libros) {
                return repoLibros.save(Libros);
        }

        @Transactional(readOnly = true)
        @Override
        public List<Libros> findAll() {
                return repoLibros.findAll();
        }

        @Transactional(readOnly = true)
        @Override
        public Optional<Libros> findById(Integer id) {
                return repoLibros.findById(id);
        }
}
