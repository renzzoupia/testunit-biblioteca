package com.biblioteca.demo.service.impl;

import com.biblioteca.demo.model.Alquileres;
import com.biblioteca.demo.repository.AlquileresRepository;
import com.biblioteca.demo.service.AlquileresService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class AlquileresServiceImpl implements AlquileresService {
        @Autowired
        private AlquileresRepository repoAlquileres;

        @Transactional
        @Override
        public Alquileres registrarAlquileres(Alquileres alquileres) {
                return repoAlquileres.save(alquileres);
        }

        @Transactional(readOnly = true)
        @Override
        public List<Alquileres> findAll() {
                return repoAlquileres.findAll();
        }

        @Transactional(readOnly = true)
        @Override
        public Optional<Alquileres> findById(Integer id) {
                return repoAlquileres.findById(id);
        }
}
