package com.biblioteca.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Table(name = "editoriales")
@Builder
public class Editoriales {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_editorial")
        private Integer idEditorial;
        @Column(name = "editorial")
        private String editorial;
}
