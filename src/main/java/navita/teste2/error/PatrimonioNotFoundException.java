package navita.teste2.error;

public class PatrimonioNotFoundException extends RuntimeException {

   
    
    public PatrimonioNotFoundException(String nome) {
        super("Patrimonio nao encontrado : " + nome);
    }
    
    public PatrimonioNotFoundException(Long id) {
        super("Patrimonio nao encontrado : " + id);
    }
}
