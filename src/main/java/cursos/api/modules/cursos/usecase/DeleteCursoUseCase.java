package cursos.api.modules.cursos.usecase;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cursos.api.modules.cursos.entity.CursoEntity;
import cursos.api.modules.cursos.exceptions.CursoNotFound;
import cursos.api.modules.cursos.repository.CursoRepository;
import lombok.NonNull;

@Service
public class DeleteCursoUseCase {

    @Autowired
    private CursoRepository cursoRepository;

    public CursoEntity execute(@NonNull UUID id) {
        var cursoOptional = cursoRepository.findById(id);

        if (cursoOptional.isPresent()) {
            var curso = cursoOptional.get();
            cursoRepository.delete(curso);
            return curso;
        } else {
            throw new CursoNotFound("Curso não encontrado");
        }
    }
}
