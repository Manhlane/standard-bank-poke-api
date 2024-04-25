package pokemon.api.standardbankpokeapi.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pokemon.api.standardbankpokeapi.entities.PokemonApiUser;
import org.springframework.security.core.AuthenticationException;
import pokemon.api.standardbankpokeapi.exceptions.AuthenticationFailedException;
import pokemon.api.standardbankpokeapi.exceptions.ResourceNotFoundException;
import pokemon.api.standardbankpokeapi.repositories.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final TokenService tokenService;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public String authenticate(String email, String password) throws AuthenticationFailedException {
        try {
            Optional<PokemonApiUser> user = userRepository.findByEmail(email);
            if(user.isEmpty()){
                throw new AuthenticationFailedException("User not found");
            }
            if(!passwordEncoder.matches(password, user.get().getPassword())){
                throw new AuthenticationFailedException("Invalid credentials");
            }
            return tokenService.generateToken(user.get());

        } catch (AuthenticationException e) {
            throw new AuthenticationFailedException("Invalid User or Password");
        }
    }

}
