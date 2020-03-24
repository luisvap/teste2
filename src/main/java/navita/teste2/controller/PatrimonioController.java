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

import navita.teste2.error.PatrimonioNotFoundException;
import navita.teste2.model.Patrimonio;
import navita.teste2.repository.PatrimonioRepository;

@RestController
public class PatrimonioController {

	@Autowired
	private PatrimonioRepository repository;
	
	
	
	
	// Find
    @GetMapping("/patrimonio")
    private List<Patrimonio> findAll() {
        return repository.findAll();
    }

    // Save
    @PostMapping("/patrimonio")
    //return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    private Patrimonio newPatrimonio(@RequestBody Patrimonio newPatrimonio) {
        return repository.save(newPatrimonio);
    }

    // Find
    @GetMapping("/patrimonio/{id}")
    private Patrimonio findOneById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new PatrimonioNotFoundException(id));
    }
    
 // Find
    @GetMapping("/patrimonio/{nome}")
    private Patrimonio findOneByNome(@PathVariable String nome) {
        return repository.findByNome(nome)
                .orElseThrow(() -> new PatrimonioNotFoundException(nome));
    }

   

    // Save or update
    @PutMapping("/patrimonio/{id}")
    private Patrimonio saveOrUpdate(@RequestBody Patrimonio patrimonio, 
    		@PathVariable Long id) {

        return repository.findById(id)
                .map(x -> {
                    x.setDescricao(patrimonio.getDescricao());
                    x.setNome(patrimonio.getNome());
                    x.setMarca(patrimonio.getMarca());
                    return repository.save(x);
                })
                .orElseGet(() -> {
                	patrimonio.setNumTombo(id.intValue());
                    return repository.save(patrimonio);
                });
    }

    

    @DeleteMapping("/patrimonio/{id}")
    private void deletePatrimonio(@PathVariable Long id) {
        repository.deleteById(id);
    }
	
}
