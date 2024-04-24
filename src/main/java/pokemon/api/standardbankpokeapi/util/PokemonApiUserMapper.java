package pokemon.api.standardbankpokeapi.util;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pokemon.api.standardbankpokeapi.entities.PokemonApiUser;
import pokemon.api.standardbankpokeapi.entities.PokemonApiUserRequest;
import pokemon.api.standardbankpokeapi.entities.PokemonApiUserResponse;

@Component
@RequiredArgsConstructor
public class PokemonApiUserMapper {

    private final ModelMapper mapper;

    public PokemonApiUser toModel(PokemonApiUserRequest pokemonApiUserRequest){
        return mapper.map(pokemonApiUserRequest, PokemonApiUser.class);
    }

    public PokemonApiUserRequest toRequest(PokemonApiUser pokemonApiUser){
        return mapper.map(pokemonApiUser, PokemonApiUserRequest.class);
    }

    public PokemonApiUserResponse toResponse(PokemonApiUser pokemonApiUser){
        return mapper.map(pokemonApiUser, PokemonApiUserResponse.class);
    }
}
