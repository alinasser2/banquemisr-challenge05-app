package banquemisr.challenge05.application.dto;

import banquemisr.challenge05.application.entity.User;
import lombok.*;
import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Builder
public class NotificationDto {

    private User to;

    private String subject;

    private Date createdAt;

}
