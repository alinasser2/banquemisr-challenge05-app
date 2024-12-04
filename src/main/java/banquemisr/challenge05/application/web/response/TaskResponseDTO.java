package banquemisr.challenge05.application.web.response;

import banquemisr.challenge05.application.enums.TaskPriority;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class TaskResponseDTO {
    private UUID id;
    private String title;
    private String description;
    private String status;
    private TaskPriority priority;
    private LocalDateTime dueDate;
    private LocalDateTime createdAt;
}
