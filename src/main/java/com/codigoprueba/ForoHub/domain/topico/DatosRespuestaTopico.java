package com.codigoprueba.ForoHub.domain.topico;

import java.time.LocalDateTime;

public record DatosRespuestaTopico(String titulo, String mensaje, LocalDateTime fechaCreacion, Enum<Status> status,
                                   String perfil) {
}
