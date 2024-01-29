package cursos.api.modules.cursos.usecase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cursos.api.modules.cursos.entity.CursoEntity;
import cursos.api.modules.cursos.repository.CursoRepository;

@Service
public class ListCursosUseCase {
    
    @Autowired
    private CursoRepository cursoRepository;

    public List<CursoEntity> execute(){
        return cursoRepository.findAll();
    }

}
