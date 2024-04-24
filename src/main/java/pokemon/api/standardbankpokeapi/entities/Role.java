package pokemon.api.standardbankpokeapi.entities;

import lombok.Getter;

@Getter
public enum Role {
    USER("user"), ADMIN("admin");

    Role(String name) {
    }
}
