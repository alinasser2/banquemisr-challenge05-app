package banquemisr.challenge05.application.enums;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorMessage {
    RESOURCE_NOT_FOUND("Resource not found"),
    INVALID_REQUEST("Invalid request"),
    INTERNAL_SERVER_ERROR("Internal server error");

    private final String message;
}