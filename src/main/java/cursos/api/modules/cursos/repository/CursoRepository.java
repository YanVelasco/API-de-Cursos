package cursos.api.modules.cursos.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import cursos.api.modules.cursos.entity.CursoEntity;

public interface CursoRepository extends JpaRepository<CursoEntity, UUID>{
    Optional<CursoEntity> findByNameIgnoreCase(String name);
}
