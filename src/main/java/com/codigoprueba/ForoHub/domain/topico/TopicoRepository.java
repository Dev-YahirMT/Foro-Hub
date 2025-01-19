package com.codigoprueba.ForoHub.domain.topico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TopicoRepository extends JpaRepository<Topico,Long> {
    // Usamos JPQL para ordenar por fecha_creacion de forma ascendente
    @Query("SELECT t FROM Topico t WHERE t.status = 'ACTIVO' ORDER BY t.fechaCreacion ASC")
    Page<Topico> findActiveTopicsOrderedByCreationDate(Pageable pageable);
}
