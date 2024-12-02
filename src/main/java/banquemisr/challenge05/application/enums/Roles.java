package banquemisr.challenge05.application.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Roles {
    USER("User"),
    ADMIN("Admin");
    private final String desc;
}

