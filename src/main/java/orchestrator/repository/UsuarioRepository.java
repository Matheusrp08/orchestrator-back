package orchestrator.repository;

//----------------------------
//Usuario Repository
//----------------------------

import org.springframework.data.jpa.repository.JpaRepository;

import orchestrator.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}