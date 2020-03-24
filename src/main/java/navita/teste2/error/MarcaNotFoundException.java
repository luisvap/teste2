package navita.teste2.error;

public class MarcaNotFoundException extends RuntimeException {

   
    
    public MarcaNotFoundException(String nome) {
        super("Marca nao encontrada : " + nome);
    }
    
    public MarcaNotFoundException(Long id) {
        super("Marca nao encontrada : " + id);
    }
}
