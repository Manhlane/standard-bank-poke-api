package pokemon.api.standardbankpokeapi.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pokemon.api.standardbankpokeapi.entities.*;
import pokemon.api.standardbankpokeapi.exceptions.AuthenticationFailedException;
import pokemon.api.standardbankpokeapi.services.AuthenticationService;
import pokemon.api.standardbankpokeapi.services.PokemonUserService;
import pokemon.api.standardbankpokeapi.util.PokemonApiUserMapper;
import jakarta.annotation.security.RolesAllowed;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pokemon-api-user")
@RequiredArgsConstructor
public class PokemonApiUserController {

    private final PokemonUserService pokemonUserService;
    private final PokemonApiUserMapper pokemonApiUserMapper;
    private final AuthenticationService authenticationService;

    @GetMapping
    @RolesAllowed( {"ADMIN","USER"} )
    public ResponseEntity<List<PokemonApiUserResponse>> getUsers() {
        List<PokemonApiUser> users = pokemonUserService.find();
        var resp = users.stream().map(pokemonApiUserMapper::toResponse).toList();
        return ResponseEntity.ok(resp);
    }

    @PostMapping
    public ResponseEntity<PokemonApiUserResponse> createUser(@RequestBody @Valid PokemonApiUserRequest pokemonApiUserRequest) {
        var user = pokemonApiUserMapper.toModel(pokemonApiUserRequest);
        user = pokemonUserService.save(user);
        var resp = pokemonApiUserMapper.toResponse(user);
        return ResponseEntity.created(URI.create(user.getId().toString())).body(resp);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody @Valid AuthenticationRequest request) throws AuthenticationFailedException {
        var token = authenticationService.authenticate(request.getEmail(), request.getPassword());
        return ResponseEntity.ok(new AuthenticationResponse(token));
    }
}
