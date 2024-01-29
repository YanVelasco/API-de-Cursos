package cursos.api.modules.cursos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cursos.api.modules.cursos.dto.CursoDTO;
import cursos.api.modules.cursos.usecase.CreateCursoUseCase;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/curso")
public class CursoController {
    
    @Autowired
    private CreateCursoUseCase createCursoUseCase;

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody @Valid CursoDTO cursosDTO){
        try {
            var result = createCursoUseCase.execute(cursosDTO);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
