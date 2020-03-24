package navita.teste2.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import navita.teste2.model.Usuario;

public interface UsuarioRepository extends 
JpaRepository<Usuario, Long> {

	public Optional<Usuario> findByEmail(String email);

	public Optional<Usuario> findByEmailAndSenha(String email, String senha);
}