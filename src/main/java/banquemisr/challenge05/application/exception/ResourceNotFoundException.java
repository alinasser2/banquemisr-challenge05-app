package banquemisr.challenge05.application.exception;

import banquemisr.challenge05.application.enums.ErrorMessage;
import banquemisr.challenge05.application.web.response.ErrorResponse;
import lombok.Getter;

@Getter
public class ResourceNotFoundException extends RuntimeException {

    private final ErrorMessage errorMessage;

    public ResourceNotFoundException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
        this.errorMessage = errorMessage;
    }

}
