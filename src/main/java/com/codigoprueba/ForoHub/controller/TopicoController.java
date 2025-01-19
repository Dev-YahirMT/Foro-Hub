package com.codigoprueba.ForoHub.controller;

import com.codigoprueba.ForoHub.domain.curso.Curso;
import com.codigoprueba.ForoHub.domain.curso.DatosRegistroCurso;
import com.codigoprueba.ForoHub.domain.curso.DatosRespuestaCurso;
import com.codigoprueba.ForoHub.domain.topico.*;
import com.codigoprueba.ForoHub.domain.usuario.DatosRespuestaUsuario;
import com.codigoprueba.ForoHub.domain.usuario.Usuario;
import com.codigoprueba.ForoHub.domain.usuario.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping()
    public ResponseEntity<Page<DatosListadoTopicos>> listaTopicos(@PageableDefault(size = 10, page = 0) Pageable paginacion){
        return ResponseEntity.ok(topicoRepository.findActiveTopicsOrderedByCreationDate(paginacion).map(DatosListadoTopicos::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity retornarDatosTopico(@PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);
        var datosTopico = new DatosRespuestaTopico(topico.getId(),topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(), topico.getStatus(),topico.getAutor().getPerfil());
        return ResponseEntity.ok(datosTopico);
    }

    @GetMapping("/p")
    public List<Topico> listaTopicos(){
                return topicoRepository.findAll();
//        return topicoRepository.findAll().stream()
//                .map( e -> new DatosListadoTopicos( e ))
//                .toList();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity actualizarTopico(@RequestBody DatosActualizarTopico datosActualizarTopico, @PathVariable Long id){
        Optional<Topico> optionalTopico = topicoRepository.findById(id);
        if (!optionalTopico.isPresent()) {
            // Si no existe, devuelve un error 404
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El tópico con id " + id + " no existe.");
        }
        Topico topico = optionalTopico.get();
        topico.actualizarDatos(datosActualizarTopico);
        return ResponseEntity.ok(new DatosRespuestaTopico(topico.getId(),topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(), topico.getStatus(),topico.getAutor().getPerfil()));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id){
        Optional<Topico> optionalTopico = topicoRepository.findById(id);
        if (!optionalTopico.isPresent()) {
            // Si no existe, devuelve un error 404
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El tópico con id " + id + " no existe.");
        }
        topicoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity registrarCurso(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico, UriComponentsBuilder uriComponentsBuilder) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(datosRegistroTopico.autor());
        if (!optionalUsuario.isPresent()) {
            // Si no existe, devuelve un error 404
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El usuario con id " + datosRegistroTopico.autor() + " no existe.");
        }
        DatosRespuestaUsuario usuario = new DatosRespuestaUsuario(optionalUsuario.get().getNombre(),optionalUsuario.get().getCorreoElectronico(),optionalUsuario.get().getPerfil());
        Topico topico = topicoRepository.save(new Topico(datosRegistroTopico, optionalUsuario.get()));
        DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(topico.getId(),topico.getTitulo(),topico.getMensaje(),topico.getFechaCreacion(),topico.getStatus(),usuario.perfil());
        URI url = uriComponentsBuilder.path("/curso/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaTopico);
    }

}
