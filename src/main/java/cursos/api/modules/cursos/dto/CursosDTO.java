package cursos.api.modules.cursos.dto;

import cursos.api.modules.cursos.entity.Active;

public record CursosDTO(
        String name,
        String category,
        Active active) {
}
