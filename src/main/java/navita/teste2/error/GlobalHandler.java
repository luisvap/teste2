package navita.teste2.error;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalHandler extends ResponseEntityExceptionHandler {

    // Let Spring handle the exception, we just override the status code
    @ExceptionHandler(PatrimonioNotFoundException.class)
    public void springHandleNotFoundPatrimonio(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.NOT_FOUND.value());
    }

    
    @ExceptionHandler(UsuarioNotFoundException.class)
    public void springHandleNotFoundUsuario(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.NOT_FOUND.value());
    }
    
    @ExceptionHandler(MarcaNotFoundException.class)
    public void springHandleNotFoundMarca(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.NOT_FOUND.value());
    }
    
   

}
