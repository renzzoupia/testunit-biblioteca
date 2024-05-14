package com.biblioteca.demo.service.impl;

import com.biblioteca.demo.model.Lectores;
import com.biblioteca.demo.repository.LectoresRepository;
import com.biblioteca.demo.service.LectoresService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class LectoresServiceImpl implements LectoresService {
        @Autowired
        private LectoresRepository repoLectores;

        @Transactional
        @Override
        public Lectores registrarLectores(Lectores lectores) {
                return repoLectores.save(lectores);
        }

        @Transactional(readOnly = true)
        @Override
        public List<Lectores> findAll() {
                return repoLectores.findAll();
        }

        @Transactional(readOnly = true)
        @Override
        public Optional<Lectores> findById(Integer id) {
                return repoLectores.findById(id);
        }
}
