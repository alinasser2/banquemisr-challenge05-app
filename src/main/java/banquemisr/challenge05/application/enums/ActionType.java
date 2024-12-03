package banquemisr.challenge05.application.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ActionType {
    CREATED("created"),
    UPDATED("updated"),
    DELETED("deleted"),
    STATUS_CHANGED("status changed");
    private final String desc;
}
