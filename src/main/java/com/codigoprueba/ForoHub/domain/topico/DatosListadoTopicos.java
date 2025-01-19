package com.codigoprueba.ForoHub.domain.topico;

import java.time.LocalDateTime;

public record DatosListadoTopicos(
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        Enum<Status> status,
        String autor

) {
    public DatosListadoTopicos(Topico topico) {
        this(topico.getTitulo(), topico.getMensaje(),topico.getFechaCreacion(),topico.getStatus(),topico.getAutor().getPerfil());
    }
}
