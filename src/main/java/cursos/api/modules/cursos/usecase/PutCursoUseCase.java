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
        Optional<CursoEntity> optionalCurso = cursoRepository.findById(id);

        if (optionalCurso.isPresent()) {
            CursoEntity existingCurso = optionalCurso.get();

            existingCurso.setName(updateCurso.name());
            existingCurso.setCategory(updateCurso.category());

            cursoRepository.save(existingCurso);

            return existingCurso;
        } else {

            throw new CursoNotFound("Curso não encontrado");
            
        }
    }
}
