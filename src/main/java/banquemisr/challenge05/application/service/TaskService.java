package banquemisr.challenge05.application.service;

import banquemisr.challenge05.application.dto.TaskRequestDTO;
import banquemisr.challenge05.application.response.TaskResponseDTO;

import java.util.List;
import java.util.UUID;

public interface TaskService {
    TaskResponseDTO createTask(TaskRequestDTO taskRequest);
    TaskResponseDTO updateTask(UUID id, TaskRequestDTO taskRequest);
    TaskResponseDTO getTaskById(UUID id);
    List<TaskResponseDTO> getAllTasks();
    void deleteTask(UUID id);
}
