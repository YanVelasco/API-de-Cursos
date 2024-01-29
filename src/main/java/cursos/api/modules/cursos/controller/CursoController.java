package cursos.api.modules.cursos.controller;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cursos.api.modules.cursos.dto.CursoDTO;
import cursos.api.modules.cursos.dto.ListOfCursosDTO;
import cursos.api.modules.cursos.dto.UpdateCurso;
import cursos.api.modules.cursos.usecase.CreateCursoUseCase;
import cursos.api.modules.cursos.usecase.DeleteCursoUseCase;
import cursos.api.modules.cursos.usecase.ListCursosUseCase;
import cursos.api.modules.cursos.usecase.PutCursoUseCase;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/curso")
public class CursoController {
    
    @Autowired
    private CreateCursoUseCase createCursoUseCase;

    @Autowired
    private ListCursosUseCase listCursosUseCase;

    @Autowired
    private PutCursoUseCase putCursoUseCase;

    @Autowired
    private DeleteCursoUseCase deleteCursoUseCase;

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody @Valid CursoDTO cursosDTO){
        try {
            var result = createCursoUseCase.execute(cursosDTO);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<ListOfCursosDTO>> listOfCursos() {
        List<ListOfCursosDTO> listOfCursos = listCursosUseCase.execute()
                .stream()
                .map(curso -> new ListOfCursosDTO(curso.getName(), curso.getCategory()))
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(listOfCursos);
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> updateCurso(@PathVariable UUID id, @RequestBody UpdateCurso updateCurso) {
        
        try {
            var result = putCursoUseCase.execute(id, updateCurso);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteCurso(@PathVariable UUID id){
        try {
            var result = deleteCursoUseCase.execute(id);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
