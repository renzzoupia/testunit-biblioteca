package com.biblioteca.demo.service;

import com.biblioteca.demo.model.Alquileres;
import java.util.List;
import java.util.Optional;

public interface AlquileresService {
     public Alquileres registrarAlquileres(Alquileres alquileres);

        public List<Alquileres> findAll();

        public Optional<Alquileres> findById(Integer id);
}
