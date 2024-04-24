package pokemon.api.standardbankpokeapi.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pokemon.api.standardbankpokeapi.entities.PokemonApiUser;
import pokemon.api.standardbankpokeapi.exceptions.ResourceAlreadyExistsException;
import pokemon.api.standardbankpokeapi.repositories.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PokemonUserService implements UserDetailsService {

    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepo.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    public PokemonApiUser save(PokemonApiUser user){
        if (userRepo.existsByEmail(user.getEmail())){
            throw new ResourceAlreadyExistsException("User", user.getEmail());
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    public List<PokemonApiUser> find(){
        return  userRepo.findAll();
    }
}
