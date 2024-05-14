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
@Table(name = "categorias")
@Builder
public class Categorias {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_categoria")
        private Integer idCategoria;
        @Column(name = "categoria", length = 55)
        private String categoria;
}
