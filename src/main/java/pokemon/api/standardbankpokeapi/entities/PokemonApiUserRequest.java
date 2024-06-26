package pokemon.api.standardbankpokeapi.entities;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class PokemonApiUserRequest {
    private Integer id;

    @NotEmpty(message = "{required.field}")
    private String name;

    @NotEmpty(message = "{required.field}")
    private String email;

    @NotEmpty(message = "{required.field}")
    private String password;

    @NotEmpty(message = "{required.field}")
    private String role;
}
