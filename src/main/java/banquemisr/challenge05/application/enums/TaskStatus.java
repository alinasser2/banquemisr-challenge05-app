package banquemisr.challenge05.application.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TaskStatus {
    TODO("todo"),
    IN_PROGRESS("in progress"),
    DONE("done");
    private final String desc;
}