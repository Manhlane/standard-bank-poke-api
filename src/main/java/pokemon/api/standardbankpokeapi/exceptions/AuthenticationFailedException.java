package pokemon.api.standardbankpokeapi.exceptions;

import javax.naming.AuthenticationException;

public class AuthenticationFailedException extends AuthenticationException {

    public AuthenticationFailedException(String msg) {
        super(msg);
    }

}
