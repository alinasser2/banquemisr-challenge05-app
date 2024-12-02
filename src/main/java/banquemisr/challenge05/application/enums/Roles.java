package banquemisr.challenge05.application.enums;

import lombok.Getter;

@Getter
public enum Roles {
    USER("User"),
    ADMIN("Admin");

    private final String desc;

    // Constructor to set the description
    Roles(String desc) {
        this.desc = desc;
    }
}
