package comportfolioARGPROG.tb.Repository;

import comportfolioARGPROG.tb.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepo extends JpaRepository<Usuario,Long> {
}
