package pokemon.api.standardbankpokeapi.entities;

import lombok.Data;

@Data
public class PokemonApiUserResponse {
    private Integer id;
    private String name;
    private String email;
    private String role;
}
