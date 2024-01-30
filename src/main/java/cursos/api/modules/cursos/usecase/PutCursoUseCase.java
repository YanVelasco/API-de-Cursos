package cursos.api.modules.cursos.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cursos.api.modules.cursos.dto.UpdateCurso;
import cursos.api.modules.cursos.entity.CursoEntity;
import cursos.api.modules.cursos.exceptions.CursoNotFound;
import cursos.api.modules.cursos.repository.CursoRepository;
import lombok.NonNull;

import java.util.Optional;
import java.util.UUID;

@Service
public class PutCursoUseCase {

    @Autowired
    private CursoRepository cursoRepository;

    public CursoEntity execute(@NonNull UUID id, UpdateCurso updateCurso) {
        Optional<CursoEntity> curso = cursoRepository.findById(id);

        if (curso.isPresent()) {
            CursoEntity existingCurso = curso.get();

            existingCurso.setName(updateCurso.name() != null ? updateCurso.name() : existingCurso.getName());
            
            existingCurso
                    .setCategory(updateCurso.category() != null ? updateCurso.category() : existingCurso.getCategory());

            cursoRepository.save(existingCurso);

            return existingCurso;
        } else {
            throw new CursoNotFound("Curso não encontrado");
        }
    }
}
