/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.biblioteca.demo.repository;

import com.biblioteca.demo.model.Alquileres;
import com.biblioteca.demo.model.Autores;
import com.biblioteca.demo.model.Categorias;
import com.biblioteca.demo.model.Editoriales;
import com.biblioteca.demo.model.Lectores;
import com.biblioteca.demo.model.Libros;
import com.biblioteca.demo.service.impl.LibrosServiceImpl;
import java.time.LocalDate;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class BibliotecaRepositoryTest {

    @Autowired
    private LibrosRepository repoLibros;
    @Autowired
    private AlquileresRepository repoAlquileres;
    @Autowired
    private AutoresRepository repoAutores;
    @Autowired
    private CategoriasRepository repoCategorias;
    @Autowired
    private EditorialesRepository repoEditoriales;
    @Autowired
    private LectoresRepository repoLectores;
    @InjectMocks
    private LibrosServiceImpl serviceLibrosMock;
    private Libros Libros1;
    private Libros Libros2;
    private List<Libros> listLibross;

    private Autores autor;
    private Autores saveAutor;

    private Categorias categoria;
    private Categorias saveCategoria;

    private Editoriales editorial;
    private Editoriales saveEditorial;

    private Alquileres alquiler;
    private Alquileres saveAlquiler;

    private Lectores lector;
    private Lectores saveLector;

    @BeforeEach
    void setUp() throws Exception{
                //Agregando autor
                autor = Autores.builder()
                                .autor("Mario Vargas Llosa")
                                .build();
		
                saveAutor = Autores.builder()
                                .idAutor(1)
                                .autor("Mario Vargas Llosa")
                                .build();

                //Agregando Categoria
                categoria = Categorias.builder()
                                .categoria("Novela")
                                .build();
		
                saveCategoria = Categorias.builder()
                                .idCategoria(1)
                                .categoria("Novela")
                                .build();

                //Agregando editorial
                editorial = Editoriales.builder()
                                .editorial("Editorial Seix Barral")
                                .build();
		
                saveEditorial = Editoriales.builder()
                                .idEditorial(1)
                                .editorial("Editorial Seix Barral")
                                .build();

                Libros1 = Libros.builder()
                                .titulo("La Ciudad y los Perros")
                                .fechaDeLanzamiento(LocalDate.of(1963, 01, 01))
                                .autores(autor)
                                .categorias(categoria)
                                .editoriales(editorial)
                                .idioma("Español")
                                .paginas(352)
                                .descripcion("La Ciudad y los Perros es una novela que retrata la vida en "
                                    + "el Colegio Militar Leoncio Prado de Lima, Perú, y la forma en que la violencia y la corrupción"
                                    + " afectan a los jóvenes que estudian allí.")
                                .portada("portadas/la-ciudad-y-los-perros.jpg")
                                .build();

                Libros2 = Libros.builder()
                                .titulo("La Ciudad y los Perros")
                                .fechaDeLanzamiento(LocalDate.of(1963, 01, 01))
                                .autores(autor)
                                .categorias(categoria)
                                .editoriales(editorial)
                                .idioma("Español")
                                .paginas(352)
                                .descripcion("La Ciudad y los Perros es una novela que retrata la vida en "
                                    + "el Colegio Militar Leoncio Prado de Lima, Perú, y la forma en que la violencia y la corrupción"
                                    + " afectan a los jóvenes que estudian allí.")
                                .portada("portadas/la-ciudad-y-los-perros.jpg")
                                .build();
                //Agregando lector
                lector = Lectores.builder()
                                .dni("74500075")
                                .nombre("Renzo Upiachihua")
                                .telefono("962822212")
                                .direccion("Jr. Miraflores 341")
                                .codigoPostal("222202")
                                .observaciones("Debe 3 libros")
                                .build();
		
                saveLector = Lectores.builder()
                                .dni("74500075")
                                .nombre("Renzo Upiachihua")
                                .telefono("962822212")
                                .direccion("Jr. Miraflores 341")
                                .codigoPostal("222202")
                                .observaciones("Debe 3 libros")
                                .build();

                //Agregando alquiler
                alquiler = Alquileres.builder()
                                .idLector(lector)
                                .idLibro(Libros1)
                                .fechaSalida(LocalDate.now())
                                .fechaEntrada(LocalDate.of(2024, 05, 23))
                                .build();
		
                saveAlquiler = Alquileres.builder()
                                .idLector(lector)
                                .idLibro(Libros1)
                                .fechaSalida(LocalDate.now())
                                .fechaEntrada(LocalDate.of(2024, 05, 23))
                                .build();
                listLibross = List.of(Libros1, Libros2);
    }
    @AfterEach
    void tearDown() throws Exception{
        Libros1 = null;
        Libros2 = null;
        //listLibross.clear(); //soluciono el primer error
    }

    @DisplayName("Libros - CP1: Prueba de inserción de un nuevo libro")
    @Test
    void repo_libro_save_returnSaveLibros(){
        Libros saveLibros = repoLibros.save(Libros1);
        assertNotNull(saveLibros);
        assertEquals(saveLibros.getTitulo(), "La Ciudad y los Perros");
        assertThat(saveLibros.getASIN()).isNotNull();
    }

    @DisplayName("Libros - CP2: Prueba de búsqueda de libros por titulo")
    @Test
    void repo_libro_save_returnLibrosTitulo(){
        // Guardar un libro en la base de datos
        Libros libroGuardado = repoLibros.save(Libros1);

        // Buscar libros por título en la base de datos
        List<Libros> librosEncontrados = repoLibros.findByTitulo("La Ciudad y los Perros");

        // Verificar que se encontraron libros
        assertFalse(librosEncontrados.isEmpty());

        assertEquals("La Ciudad y los Perros", libroGuardado.getTitulo());
    }

    @DisplayName("Alquileres - CP1: Prueba de registro de un nuevo alquiler")
    @Test
    void repo_alquier_save_returnSaveAlquiler(){
        Alquileres saveAlquiler = this.repoAlquileres.save(alquiler);
        assertNotNull(saveAlquiler);
        assertEquals(saveAlquiler.getIdLibro(), Libros1);

    }

    @DisplayName("Alquileres - CP2: Prueba de devolución de un libro alquilado")
    @Test
    void repo_alquiler_devolucion_returnLibroFechaIngreso() {
        // Guardar el alquiler en la base de datos
        Alquileres alquilerGuardado = repoAlquileres.save(alquiler);
        assertNotNull(alquilerGuardado);

        // Devolver el libro alquilado
        alquilerGuardado.setFechaEntrada(LocalDate.now()); // Asignar la fecha de devolución actual
        Alquileres alquilerDevolucion = repoAlquileres.save(alquilerGuardado);

        // Verificar que se haya devuelto el libro
        assertNotNull(alquilerDevolucion);

        // Verificar que la fecha de devolución se haya actualizado
        assertNotNull(alquilerDevolucion.getFechaEntrada());
    }

    @DisplayName("Autores - CP1: Prueba de inserción de un nuevo autor")
    @Test
    void repo_autores_save_returnSaveAutorr(){
        Autores saveAutor = this.repoAutores.save(autor);
        assertNotNull(saveAutor);
        assertEquals(saveAutor.getAutor(), "Mario Vargas Llosa");

    }

    @DisplayName("Autores - CP2: Prueba de búsqueda de autores por nombre")
    @Test
    void repo_Autores_save_returnAutoresNombre(){
        // Guardar un autor en la base de datos
        Autores autorGuardado = repoAutores.save(autor);

        // Buscar autores por nombre en la base de datos
        List<Autores> autoresEncontrados = repoAutores.findByAutor("Mario Vargas Llosa");

        // Verificar que se encontraron autores
        assertFalse(autoresEncontrados.isEmpty());
        assertEquals("Mario Vargas Llosa", autorGuardado.getAutor());
    }

    @DisplayName("Categorias - CP1: Prueba de inserción de una nueva categoría")
    @Test
    void repo_categorias_save_returnSaveCategoria(){
        Categorias saveCategoria = this.repoCategorias.save(categoria);
        assertNotNull(saveCategoria);
        assertEquals(saveCategoria.getCategoria(), "Novela");

    }

    @DisplayName("Categorias - CP2: Prueba de búsqueda de categorías por nombre")
    @Test
    void repo_categoria_save_returnCategoriaNombre(){
        // Guardar una categoria en la base de datos
        Categorias categoriaGuardada = repoCategorias.save(categoria);

        // Buscar categorias por nombre en la base de datos
        List<Categorias> categoriasEncontradas = repoCategorias.findByCategoria("Novela");

        // Verificar que se encontraron categorias
        assertFalse(categoriasEncontradas.isEmpty());
        assertEquals("Novela", categoriaGuardada.getCategoria());
    }   

    @DisplayName("Editoriales - CP1: Prueba de inserción de una nueva editorial")
    @Test
    void repo_editoriales_save_returnSaveEditorial(){
        Editoriales saveEditorial = this.repoEditoriales.save(editorial);
        assertNotNull(saveEditorial);
        assertEquals(saveEditorial.getEditorial(), "Editorial Seix Barral");

    }
    @DisplayName("Editoriales - CP2: Prueba de búsqueda de editoriales por nombre")
    @Test
    void repo_Editorial_save_returnEditorialPorNombre(){
        // Guardar una editorial en la base de datos
        Editoriales editorialGuardada = repoEditoriales.save(editorial);

        // Buscar editoriales por nombre en la base de datos
        List<Editoriales> editorialesEncontradas = repoEditoriales.findByEditorial("Editorial Seix Barral");

        // Verificar que se encontraron editoriales
        assertFalse(editorialesEncontradas.isEmpty());
        assertEquals("Editorial Seix Barral", editorialGuardada.getEditorial());
    }   

    @DisplayName("Lectores - CP1: Prueba de inserción de un nuevo lector")
    @Test
    void repo_lectores_save_returnSaveLectores(){
        Lectores saveLector = this.repoLectores.save(lector);
        assertNotNull(saveLector);
        assertEquals(saveLector.getNombre(), "Renzo Upiachihua");

    }

    @DisplayName("Lectores - CP2: Prueba de búsqueda de lectores por DNI")
    @Test
    void repo_lectores_save_returnLectoresPorDni(){
        // Guardar un libro en la base de datos
        Lectores lectorGuardado = repoLectores.save(lector);

        // Buscar libros por título en la base de datos
        List<Lectores> lectoresEncontrados = repoLectores.findByDni(lector.getDni());

        // Verificar que se encontraron libros
        assertFalse(lectoresEncontrados.isEmpty()); // Verificar que se encontraron libros

        // Verificar que el libro encontrado coincide con el libro guardado
        Lectores libroEncontrado = lectoresEncontrados.get(0);
        assertEquals(lectorGuardado.getDni(), libroEncontrado.getDni());
    }
    
    
}
