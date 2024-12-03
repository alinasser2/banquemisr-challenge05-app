package banquemisr.challenge05.application.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TaskPriority {

    LOW("Low"),
    MEDIUM("Medium"),
    HIGH("High");

    private final String desc;
}
