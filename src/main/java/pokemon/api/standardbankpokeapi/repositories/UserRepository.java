package pokemon.api.standardbankpokeapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pokemon.api.standardbankpokeapi.entities.PokemonApiUser;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<PokemonApiUser, Integer> {
        Optional<PokemonApiUser> findByEmail(String email);
        boolean existsByEmail(String email);
}
