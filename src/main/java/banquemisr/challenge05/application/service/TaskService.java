package banquemisr.challenge05.application.service;

import banquemisr.challenge05.application.dto.TaskDTO;
import banquemisr.challenge05.application.entity.Task;
import banquemisr.challenge05.application.web.response.TaskResponseDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface TaskService {
    TaskResponseDTO createTask(TaskDTO taskRequest);
    TaskResponseDTO updateTask(UUID id, TaskDTO taskRequest);
    TaskResponseDTO getTaskById(UUID id);
    List<TaskResponseDTO> getAllTasks();
    void deleteTask(UUID id);
    List<TaskResponseDTO> searchTasks(String title, String description, Task.Status status, LocalDateTime dueDate, Integer page, Integer size);
}
