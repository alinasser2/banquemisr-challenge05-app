package banquemisr.challenge05.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaskDTO {

    @NotBlank(message = "Title is mandatory")
    @Size(max = 255, message = "Title must be at most 255 characters")
    private String title;

    @Size(max = 500, message = "Description must be at most 500 characters")
    private String description;

    @NotNull(message = "Status is mandatory")
    private String status;

    @NotNull(message = "Priority is mandatory")
    @Min(value = 1, message = "Priority must be at least 1 (High)")
    @Max(value = 3, message = "Priority must be at most 3 (Low)")
    private Integer priority;

    @FutureOrPresent(message = "Due date must be in the present or future")
    private LocalDateTime dueDate;
}