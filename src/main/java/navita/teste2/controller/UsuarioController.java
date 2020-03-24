package navita.teste2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import navita.teste2.error.UsuarioNotFoundException;
import navita.teste2.model.Usuario;
import navita.teste2.repository.UsuarioRepository;

@RestController
public class UsuarioController {

	@Autowired
	private UsuarioRepository repository;
	
	
	// Find
    @GetMapping("/usuario")
    private List<Usuario> findAll() {
        return repository.findAll();
    }

    // Save
    @PostMapping("/usuario")
    //return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    private Usuario newUser(@RequestBody Usuario newUser) {
        return repository.save(newUser);
    }

    // Find
    @GetMapping("/usuario/{id}")
    private Usuario findOneById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException(id));
    }
    
 // Find
    @GetMapping("/usuario/{email}")
    private Usuario findOneByEmail(@PathVariable String email) {
        return repository.findByEmail(email)
                .orElseThrow(() -> new UsuarioNotFoundException(email));
    }

   

    // Save or update
    @PutMapping("/usuario/{id}")
    private Usuario saveOrUpdate(@RequestBody Usuario usuario, @PathVariable Long id) {

        return repository.findById(id)
                .map(x -> {
                    x.setSenha(usuario.getSenha());
                    x.setEmail(usuario.getEmail());
                    
                    return repository.save(x);
                })
                .orElseGet(() -> {
                	usuario.setUsuarioId(id.intValue());
                    return repository.save(usuario);
                });
    }

    

    @DeleteMapping("/usuario/{id}")
    private void deleteUsuario(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
