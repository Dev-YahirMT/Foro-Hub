package com.codigoprueba.ForoHub.controller;

import com.codigoprueba.ForoHub.domain.curso.*;
import com.codigoprueba.ForoHub.domain.topico.DatosListadoTopicos;
import com.codigoprueba.ForoHub.domain.topico.DatosRespuestaTopico;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping()
    public ResponseEntity<Page<DatosListadoCursos>> listaCursos(@PageableDefault(size = 10, page = 0) Pageable paginacion){
        return ResponseEntity.ok(cursoRepository.findAll(paginacion).map(DatosListadoCursos::new));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity actualizarCurso(@RequestBody DatosActualizarCurso datosActualizarCurso, @PathVariable Long id){
        Optional<Curso> optionalCurso = cursoRepository.findById(id);
        if(!optionalCurso.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El Curso con id " + id + " no existe.");
        }
        Curso curso = optionalCurso.get();
        curso.actualizarDatos(datosActualizarCurso);
        return ResponseEntity.ok(new DatosRespuestaCurso(curso.getId(),curso.getNombre(), curso.getCategoria()));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarCurso(@PathVariable Long id){
        Optional<Curso> optionalCurso = cursoRepository.findById(id);
        if(!optionalCurso.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El Curso con id " + id + " no existe.");
        }
        cursoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<DatosRespuestaCurso> registrarCurso(@RequestBody @Valid DatosRegistroCurso datosRegistroCurso, UriComponentsBuilder uriComponentsBuilder) {
        System.out.println(datosRegistroCurso);
        Curso curso = cursoRepository.save(new Curso(datosRegistroCurso));
        DatosRespuestaCurso datosRespuestaCurso = new DatosRespuestaCurso(curso.getId(),curso.getNombre(),curso.getCategoria());
        URI url = uriComponentsBuilder.path("/curso/{id}").buildAndExpand(curso.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaCurso);
    }



}
