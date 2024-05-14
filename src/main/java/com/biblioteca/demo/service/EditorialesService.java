package com.biblioteca.demo.service;

import com.biblioteca.demo.model.Editoriales;
import java.util.List;
import java.util.Optional;

public interface EditorialesService {
        public Editoriales registrarEditoriales(Editoriales editariales);

        public List<Editoriales> findAll();

        public Optional<Editoriales> findById(Integer id);
}
