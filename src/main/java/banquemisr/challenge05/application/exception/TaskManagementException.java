package banquemisr.challenge05.application.exception;

import banquemisr.challenge05.application.web.response.ErrorResponse;
import lombok.Getter;

@Getter
public class TaskManagementException extends RuntimeException {
    private final ErrorResponse errorResponse;

    public TaskManagementException(ErrorResponse errorResponse) {
        super(errorResponse.getMessage());
        this.errorResponse = errorResponse;
    }
}
