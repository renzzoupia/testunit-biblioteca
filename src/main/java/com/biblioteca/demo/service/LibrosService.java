package com.biblioteca.demo.service;

import com.biblioteca.demo.model.Libros;
import java.util.List;
import java.util.Optional;

public interface LibrosService {
        public Libros registrarLibros(Libros libros);

        public List<Libros> findAll();

        public Optional<Libros> findById(Integer id);
}
