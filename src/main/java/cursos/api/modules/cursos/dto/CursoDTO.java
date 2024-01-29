package cursos.api.modules.cursos.dto;

import java.sql.Timestamp;
import java.util.UUID;

import cursos.api.modules.cursos.entity.Active;

public record CursoDTO(
                UUID id,
                String name,
                String category,
                Active active,
                Timestamp createdAt,
                Timestamp updatedAt) {
}
