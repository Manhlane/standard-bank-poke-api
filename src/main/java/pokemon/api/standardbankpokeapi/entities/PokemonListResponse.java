package pokemon.api.standardbankpokeapi.entities;

import lombok.Data;

import java.util.List;

@Data
public class PokemonListResponse {
    private Integer count;
    private String next;
    private String previous;
    private List<PokemonResults> results;
}
