package pokemon.api.standardbankpokeapi.controllers;

import jakarta.annotation.security.RolesAllowed;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pokemon.api.standardbankpokeapi.entities.PokemonListResponse;
import pokemon.api.standardbankpokeapi.services.PokemonInformationService;

import java.util.List;

@RestController
@RequestMapping("/pokemon-information")
@RequiredArgsConstructor
public class PokemonInformationController {

    private final PokemonInformationService pokemonInformationService;

    @GetMapping("/get-list")
    public ResponseEntity<PokemonListResponse> getPokemonList() {
        ResponseEntity<PokemonListResponse> resp = pokemonInformationService.getPokemonList(10, 10);
        return ResponseEntity.ok(resp.getBody());
    }

    @GetMapping("/get-pokemon/{id}")
    public ResponseEntity<Object> getPokemon(@PathVariable("id") String id) {
        ResponseEntity<Object> resp = pokemonInformationService.getPokemon(id);
        return ResponseEntity.ok(resp.getBody());
    }


}
