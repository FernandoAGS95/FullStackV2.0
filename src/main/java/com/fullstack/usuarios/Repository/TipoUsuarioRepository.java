package com.fullstack.usuarios.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.fullstack.usuarios.Model.TipoUsuario;
public interface TipoUsuarioRepository  extends JpaRepository<TipoUsuario, Long> {
 

}
