package cursos.api.modules.cursos.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cursos.api.modules.cursos.dto.CursoDTO;
import cursos.api.modules.cursos.entity.Active;
import cursos.api.modules.cursos.entity.CursoEntity;
import cursos.api.modules.cursos.exceptions.CursoAlreadyExistis;
import cursos.api.modules.cursos.repository.CursoRepository;

@Service
public class CreateCursoUseCase {

    @Autowired
    private CursoRepository cursoRepository;

    public CursoEntity execute(CursoDTO cursosDTO){
        var createCurso = CursoEntity.builder()
            .id(cursosDTO.id())
            .name(cursosDTO.name())
            .category(cursosDTO.category())
            .active(Active.ATIVO)
            .createdAt(cursosDTO.createdAt())
            .updatedAt(null)
            .build();

            cursoRepository.findByNameIgnoreCase(createCurso.getName())
            .ifPresent( curso -> {
                throw new CursoAlreadyExistis("Já existe um curso com este nome");
            });

            return cursoRepository.save(createCurso);
    }

}
