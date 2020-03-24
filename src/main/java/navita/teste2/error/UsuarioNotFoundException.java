package navita.teste2.error;

public class UsuarioNotFoundException extends RuntimeException {

    public UsuarioNotFoundException(String email) {
        super("Usuario nao encontrado : " + email);
    }

    
    
    public UsuarioNotFoundException(Long id) {
        super("Usuario nao encontrado : " + id);
    }
}
