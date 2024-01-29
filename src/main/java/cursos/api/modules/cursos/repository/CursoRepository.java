package cursos.api.modules.cursos.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import cursos.api.modules.cursos.entity.Curso;

public interface CursoRepository extends JpaRepository<Curso, UUID>{
}
