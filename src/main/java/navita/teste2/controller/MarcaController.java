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

import navita.teste2.error.MarcaNotFoundException;
import navita.teste2.error.PatrimonioNotFoundException;
import navita.teste2.model.Marca;
import navita.teste2.model.Patrimonio;
import navita.teste2.repository.MarcaRepository;

@RestController
public class MarcaController {

	@Autowired
	private MarcaRepository repository;
	
	
	// Find
    @GetMapping("/marca")
    private List<Marca> findAll() {
        return repository.findAll();
    }

    // Save
    @PostMapping("/marca")
    //return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    private Marca newMarca(@RequestBody Marca newMarca) {
        return repository.save(newMarca);
    }

    // Find
    @GetMapping("/marca/{id}")
    private Marca findOneById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new MarcaNotFoundException(id));
    }
    
 // Find
    @GetMapping("/marca/{nome}")
    private Marca findOneByNome(@PathVariable String nome) {
        return repository.findByMarca(nome)
                .orElseThrow(() -> new MarcaNotFoundException(nome));
    }

   

    // Save or update
    @PutMapping("/marca/{id}")
    private Marca saveOrUpdate(@RequestBody Marca marca, 
    		@PathVariable Long id) {

        return repository.findById(id)
                .map(x -> {
                    
                    
                    x.setMarca(marca.getMarca());
                    return repository.save(x);
                })
                .orElseGet(() -> {
                	marca.setMarcaId(id.intValue());
                    return repository.save(marca);
                });
    }

    

    @DeleteMapping("/marca/{id}")
    private void deleteMarca(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
