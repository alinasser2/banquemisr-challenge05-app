package banquemisr.challenge05.application.service.serviceImpl;

import banquemisr.challenge05.application.dto.TaskDTO;
import banquemisr.challenge05.application.entity.History;
import banquemisr.challenge05.application.entity.User;
import banquemisr.challenge05.application.enums.ActionType;
import banquemisr.challenge05.application.enums.ErrorMessage;
import banquemisr.challenge05.application.enums.TaskStatus;
import banquemisr.challenge05.application.exception.ResourceNotFoundException;
import banquemisr.challenge05.application.repository.HistoryRepository;
import banquemisr.challenge05.application.repository.UserRepository;
import banquemisr.challenge05.application.service.NotificationService;
import banquemisr.challenge05.application.web.response.TaskResponseDTO;
import banquemisr.challenge05.application.entity.Task;
import banquemisr.challenge05.application.mapper.TaskMapper;
import banquemisr.challenge05.application.repository.TaskRepository;
import banquemisr.challenge05.application.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import banquemisr.challenge05.application.utils.PaginationUtils;
import org.springframework.data.domain.Page;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;





@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
    private final UserRepository userRepository;
    private final HistoryRepository historyRepo;
    private final NotificationService emailService;

    public TaskResponseDTO createTask(TaskDTO taskRequestDTO) {
        Task task = taskMapper.toEntity(taskRequestDTO);
        System.out.println(task);
        Task savedTask = taskRepository.save(task);
        return taskMapper.toDto(savedTask);
    }

    public TaskResponseDTO getTaskById(UUID id) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(email).orElseThrow();
        if (!taskRepository.existsByIdAndUserId(id, user.getId())) {
            throw new RuntimeException("Task not found with ID: " + id);
        }
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


    public List<TaskResponseDTO> searchTasks(String title, String description, TaskStatus status,
                                             LocalDateTime dueDate, Integer page, Integer size) {
        Page<Task> taskPage = taskRepository.searchTasks(title, description, status, dueDate,
                PaginationUtils.createPageable(page, size));
        return taskPage.getContent().stream()
                .map(taskMapper::toDto)
                .collect(Collectors.toList());
    }



    public TaskResponseDTO markTaskDone(UUID id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorMessage.RESOURCE_NOT_FOUND));
        task.setStatus(TaskStatus.DONE);
        Task updatedTask = taskRepository.save(task);
        History history = History.builder().actionType(ActionType.STATUS_CHANGED).task(updatedTask).CreatedAt(new Date()).build();
        historyRepo.save(history);
        User user = userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName())
                .orElseThrow(() -> new ResourceNotFoundException(ErrorMessage.RESOURCE_NOT_FOUND));
        String subject = "Task DONE: " + task.getTitle();
        String body = "Task " + task.getTitle() + " is now DONE!";
        emailService.sendEmail(user.getEmail(), subject, body);
        return taskMapper.toDto(updatedTask);
    }

    public TaskResponseDTO markTaskInProgress(UUID id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorMessage.RESOURCE_NOT_FOUND));
        task.setStatus(TaskStatus.IN_PROGRESS);
        Task updatedTask = taskRepository.save(task);
        History history = History.builder().actionType(ActionType.STATUS_CHANGED).task(updatedTask).CreatedAt(new Date()).build();
        historyRepo.save(history);
        User user = userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName())
                .orElseThrow(() -> new ResourceNotFoundException(ErrorMessage.RESOURCE_NOT_FOUND));
        String subject = "Task IN_PROGRESS: " + task.getTitle();
        String body = "Task " + task.getTitle() + " is now IN_PROGRESS!";
        emailService.sendEmail(user.getEmail(), subject, body);
        return taskMapper.toDto(updatedTask);
    }
}
