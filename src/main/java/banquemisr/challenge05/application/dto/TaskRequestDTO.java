package banquemisr.challenge05.application.dto;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class TaskRequestDTO {
    private String title;
    private String description;
    private String status;
    private Integer priority;
    private LocalDateTime dueDate;
}
