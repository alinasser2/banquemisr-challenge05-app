package banquemisr.challenge05.application.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class TaskDTO {
    private String title;
    private String description;
    private String status;
    private Integer priority;
    private LocalDateTime dueDate;
}
