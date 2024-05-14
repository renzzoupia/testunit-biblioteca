package com.biblioteca.demo.service.impl;

import com.biblioteca.demo.model.Editoriales;
import com.biblioteca.demo.repository.EditorialesRepository;
import com.biblioteca.demo.service.EditorialesService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class EditorialesServiceImpl implements EditorialesService {
    @Autowired
        private EditorialesRepository repoEditoriales;

        @Transactional
        @Override
        public Editoriales registrarEditoriales(Editoriales editoriales) {
                return repoEditoriales.save(editoriales);
        }

        @Transactional(readOnly = true)
        @Override
        public List<Editoriales> findAll() {
                return repoEditoriales.findAll();
        }

        @Transactional(readOnly = true)
        @Override
        public Optional<Editoriales> findById(Integer id) {
                return repoEditoriales.findById(id);
        }
}
