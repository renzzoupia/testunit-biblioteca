package com.biblioteca.demo.service;

import com.biblioteca.demo.model.Lectores;
import java.util.List;
import java.util.Optional;

public interface LectoresService {
        public Lectores registrarLectores(Lectores lectores);

        public List<Lectores> findAll();

        public Optional<Lectores> findById(Integer id);
}
