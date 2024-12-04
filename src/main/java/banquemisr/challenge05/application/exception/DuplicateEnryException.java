package banquemisr.challenge05.application.exception;


import banquemisr.challenge05.application.enums.ErrorMessage;
import lombok.Getter;

@Getter
public class DuplicateEnryException  extends RuntimeException{

    private final ErrorMessage errorMessage;

    public DuplicateEnryException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
        this.errorMessage = errorMessage;
    }

}
