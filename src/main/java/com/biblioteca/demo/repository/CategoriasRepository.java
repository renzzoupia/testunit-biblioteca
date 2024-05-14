/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.biblioteca.demo.repository;

import com.biblioteca.demo.model.Categorias;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriasRepository  extends JpaRepository<Categorias, Integer> {
    List<Categorias> findByCategoria(String nombreCategoria);
}
