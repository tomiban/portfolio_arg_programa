package comportfolioARGPROG.tb.exception;

import java.nio.file.attribute.UserPrincipalNotFoundException;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message){
        super(message);
    }

}
