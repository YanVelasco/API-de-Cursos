package cursos.api.modules.cursos.exceptions;

public class CursoAlreadyExistis extends RuntimeException {
    public CursoAlreadyExistis(String message){
        super(message);
    }
}
