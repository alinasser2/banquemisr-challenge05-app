package banquemisr.challenge05.application.service;

import banquemisr.challenge05.application.dto.TaskRequestDTO;
import banquemisr.challenge05.application.dto.TaskResponseDTO;
import banquemisr.challenge05.application.entity.Task;
import banquemisr.challenge05.application.mapper.TaskMapper;
import banquemisr.challenge05.application.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public TaskResponseDTO createTask(TaskRequestDTO taskRequestDTO) {
        Task task = taskMapper.toEntity(taskRequestDTO);
        Task savedTask = taskRepository.save(task);
        return taskMapper.toDto(savedTask);
    }

    public TaskResponseDTO getTaskById(UUID id) {
        Optional<Task> task = taskRepository.findById(id);
        return task.map(taskMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Task not found with ID: " + id));
    }

    public List<TaskResponseDTO> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        return tasks.stream()
                .map(taskMapper::toDto)
                .collect(Collectors.toList());
    }

    public TaskResponseDTO updateTask(UUID id, TaskRequestDTO taskRequestDTO) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with ID: " + id));

        taskMapper.updateTaskFromDto(taskRequestDTO, task);
        Task updatedTask = taskRepository.save(task);
        return taskMapper.toDto(updatedTask);
    }

    public void deleteTask(UUID id) {
        if (!taskRepository.existsById(id)) {
            throw new RuntimeException("Task not found with ID: " + id);
        }
        taskRepository.deleteById(id);
    }
}
