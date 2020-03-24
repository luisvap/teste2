package navita.teste2.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import navita.teste2.model.Patrimonio;

public interface PatrimonioRepository extends 
JpaRepository<Patrimonio, Long> {

	public Optional<Patrimonio> findByNome(String nome);

}