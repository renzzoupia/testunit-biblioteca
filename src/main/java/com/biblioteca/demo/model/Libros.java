package com.biblioteca.demo.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Table(name = "libros")
@Builder
public class Libros {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_libro")
        private Integer ASIN;

        @Column(name = "titulo")
        private String titulo;

        @Column(name = "fecha_de_lanzamiento")
        private LocalDate fechaDeLanzamiento;

        // tabla  persona se relaciona a de tipo persona
        @ManyToOne(cascade = CascadeType.PERSIST) //De muchos a uno
        @JoinColumn(name = "id_autor")
        private Autores autores;

        // tabla  persona se relaciona a de tipo persona
        @ManyToOne(cascade = CascadeType.PERSIST) //De muchos a uno
        @JoinColumn(name = "id_categoria")
        private Categorias categorias;

        // tabla  persona se relaciona a de tipo persona
        @ManyToOne(cascade = CascadeType.PERSIST) //De muchos a uno
        @JoinColumn(name = "id_editorial")
        private Editoriales editoriales;

        @Column(name = "idioma", length = 55)
        private String idioma;

        @Column(name = "paginas")
        private Integer paginas;

        @Column(name = "descripcion")
        private String descripcion;

        @Column(name = "portada")
        private String portada;

}
