package cursos.api.modules.cursos.exceptions;

public class CursoNotFound extends RuntimeException{
    public CursoNotFound(String message){
        super(message);
    }
}
