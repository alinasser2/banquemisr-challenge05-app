package banquemisr.challenge05.application.dto;

import banquemisr.challenge05.application.entity.Task;
import banquemisr.challenge05.application.enums.ActionType;
import lombok.*;
import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Builder
public class HistoryDto {

    private ActionType actionType;

    private TaskDTO task;

    private Date createdAt;

}
