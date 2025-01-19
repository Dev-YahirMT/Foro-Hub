package com.codigoprueba.ForoHub.domain.topico;

import com.codigoprueba.ForoHub.domain.usuario.Usuario;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public record DatosRegistroTopico(
        Long id,
        String titulo,
        String mensaje,
        Status status,
        Long autor
) {
}
