package banquemisr.challenge05.application.service.serviceImpl;

import banquemisr.challenge05.application.dto.TaskDTO;
import banquemisr.challenge05.application.web.response.TaskResponseDTO;
import banquemisr.challenge05.application.entity.Task;
import banquemisr.challenge05.application.mapper.TaskMapper;
import banquemisr.challenge05.application.repository.TaskRepository;
import banquemisr.challenge05.application.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import banquemisr.challenge05.application.utils.PaginationUtils;
import org.springframework.data.domain.Page;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public TaskResponseDTO createTask(TaskDTO taskRequestDTO) {
        Task task = taskMapper.toEntity(taskRequestDTO);
        System.out.println(task);
        Task savedTask = taskRepository.save(task);
        return taskMapper.toDto(savedTask);
    }

    public TaskResponseDTO getTaskById(UUID id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with ID: " + id));
        return taskMapper.toDto(task);
    }

    public List<TaskResponseDTO> getAllTasks() {
        return taskRepository.findAll()
                .stream()
                .map(taskMapper::toDto)
                .collect(Collectors.toList());
    }

    public TaskResponseDTO updateTask(UUID id, TaskDTO taskRequestDTO) {
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


    public List<TaskResponseDTO> searchTasks(String title, String description, Task.Status status,
                                             LocalDateTime dueDate, Integer page, Integer size) {
        Page<Task> taskPage = taskRepository.searchTasks(title, description, status, dueDate,
                PaginationUtils.createPageable(page, size));
        return taskPage.getContent().stream()
                .map(taskMapper::toDto)
                .collect(Collectors.toList());
    }
}
