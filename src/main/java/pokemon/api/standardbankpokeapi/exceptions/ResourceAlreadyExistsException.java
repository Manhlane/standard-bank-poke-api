package pokemon.api.standardbankpokeapi.exceptions;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class ResourceAlreadyExistsException extends RuntimeException {

    private String resourceName;
    private String resourceId;

    public String getMessage() {
        if (resourceName == null || resourceId == null)
            return null;
        return String.format("Resource '%s' already registered with id '%s'", resourceName, resourceId);
    }
}
