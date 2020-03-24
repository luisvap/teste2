package navita.teste2.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import navita.teste2.model.Marca;

public interface MarcaRepository extends 
JpaRepository<Marca, Long> {

	public Optional<Marca> findByMarca(String nome);

}