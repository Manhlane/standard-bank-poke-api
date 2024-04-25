package pokemon.api.standardbankpokeapi.services;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pokemon.api.standardbankpokeapi.entities.PokemonListResponse;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PokemonInformationService {

    private final RestTemplate restTemplate;

    public ResponseEntity<PokemonListResponse> getPokemonList(Integer limit, Integer offset){
                return restTemplate.getForEntity("https://pokeapi.co/api/v2/pokemon?limit=10",  PokemonListResponse.class);
    }

    public ResponseEntity<Object> getPokemon(String id){
        return restTemplate.getForEntity("https://pokeapi.co/api/v2/pokemon/" + id,  Object.class);
    }
}
