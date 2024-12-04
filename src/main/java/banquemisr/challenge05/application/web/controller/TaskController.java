package banquemisr.challenge05.application.web.controller;

import banquemisr.challenge05.application.dto.TaskDTO;
import banquemisr.challenge05.application.entity.Task;
import banquemisr.challenge05.application.enums.TaskStatus;
import banquemisr.challenge05.application.web.response.TaskResponseDTO;
import banquemisr.challenge05.application.service.TaskService;
import io.swagger.annotations.*;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/tasks")
@Api(tags = "Task Management", description = "Operations related to Task management")
public class TaskController {

    private final TaskService taskService;
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    @ApiOperation(
            value = "Create a new task",
            notes = "Provide task details to create a new task. Fields like `title`, `priority`, and `status` are mandatory."
    )
    @ApiResponses({
            @ApiResponse(code = 201, message = "Task successfully created", response = TaskResponseDTO.class),
            @ApiResponse(code = 400, message = "Invalid input data")
    })
    public ResponseEntity<TaskResponseDTO> createTask(
            @ApiParam(value = "Task data for the new task", required = true)
            @Valid @RequestBody TaskDTO taskRequest) {
        TaskResponseDTO createdTask = taskService.createTask(taskRequest);
        return ResponseEntity.status(201).body(createdTask);
    }

    @PutMapping("/{id}")
    @ApiOperation(
            value = "Update an existing task",
            notes = "Provide task details to update the existing task. Fields not provided will retain their existing values."
    )
    @ApiResponses({
            @ApiResponse(code = 200, message = "Task successfully updated", response = TaskResponseDTO.class),
            @ApiResponse(code = 404, message = "Task not found with the given ID"),
            @ApiResponse(code = 400, message = "Invalid input data")
    })
    public ResponseEntity<TaskResponseDTO> updateTask(
            @ApiParam(value = "UUID of the task to be updated", required = true)
            @PathVariable UUID id,
            @ApiParam(value = "Updated task data", required = true)
            @Valid @RequestBody TaskDTO taskRequest) {
        TaskResponseDTO updatedTask = taskService.updateTask(id, taskRequest);
        return ResponseEntity.ok(updatedTask);
    }

    @GetMapping("/{id}")
    @ApiOperation(
            value = "Get a task by ID",
            notes = "Provide the task ID to retrieve its details."
    )
    @ApiResponses({
            @ApiResponse(code = 200, message = "Task retrieved successfully", response = TaskResponseDTO.class),
            @ApiResponse(code = 404, message = "Task not found with the given ID")
    })
    public ResponseEntity<TaskResponseDTO> getTaskById(
            @ApiParam(value = "UUID of the task to be retrieved", required = true)
            @PathVariable UUID id) {
        return ResponseEntity.ok(taskService.getTaskById(id));
    }

    @GetMapping
    @ApiOperation(
            value = "Get all tasks",
            notes = "Retrieve a list of all tasks."
    )
    @ApiResponses({
            @ApiResponse(code = 200, message = "List of tasks retrieved successfully", response = TaskResponseDTO.class, responseContainer = "List")
    })
    public ResponseEntity<List<TaskResponseDTO>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @DeleteMapping("/{id}")
    @ApiOperation(
            value = "Delete a task by ID",
            notes = "Provide the task ID to delete the corresponding task."
    )
    @ApiResponses({
            @ApiResponse(code = 204, message = "Task successfully deleted"),
            @ApiResponse(code = 404, message = "Task not found with the given ID")
    })
    public ResponseEntity<Void> deleteTask(
            @ApiParam(value = "UUID of the task to be deleted", required = true)
            @PathVariable UUID id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/search")
    @ApiOperation(value = "Search tasks by title, description, status, or due date")
    public ResponseEntity<List<TaskResponseDTO>> searchTasks(
            @RequestParam(required = false) @ApiParam(value = "Task title to search") String title,
            @RequestParam(required = false) @ApiParam(value = "Task description to search") String description,
            @RequestParam(required = false) @ApiParam(value = "Task status (TODO, IN_PROGRESS, DONE)") TaskStatus status,
            @RequestParam(required = false) @ApiParam(value = "Task due date in ISO format") LocalDateTime dueDate,
            @RequestParam(required = false) @ApiParam(value = "Page number (default 0)") Integer page,
            @RequestParam(required = false) @ApiParam(value = "Page size (default 10)") Integer size) {

        List<TaskResponseDTO> tasks = taskService.searchTasks(title, description, status, dueDate, page, size);
        return ResponseEntity.ok(tasks);
    }


    @PatchMapping("/{id}/done")
    @ApiOperation(
            value = "Mark a task as done",
            notes = "Provide the task ID to mark it as done."
    )
    @ApiResponses({
            @ApiResponse(code = 200, message = "Task marked as done successfully", response = TaskResponseDTO.class),
            @ApiResponse(code = 404, message = "Task not found with the given ID")
    })
    public ResponseEntity<TaskResponseDTO> markTaskDone(
            @ApiParam(value = "UUID of the task to be marked as done", required = true)
            @PathVariable UUID id) {
        return ResponseEntity.ok(taskService.markTaskDone(id));
    }


    @PatchMapping("/{id}/in-progress")
    @ApiOperation(
            value = "Mark a task as in progress",
            notes = "Provide the task ID to mark it as in progress."
    )
    @ApiResponses({
            @ApiResponse(code = 200, message = "Task marked in progress successfully", response = TaskResponseDTO.class),
            @ApiResponse(code = 404, message = "Task not found with the given ID")
    })
    public ResponseEntity<TaskResponseDTO> markTaskInProgress(
            @ApiParam(value = "UUID of the task to be marked as done", required = true)
            @PathVariable UUID id) {
        return ResponseEntity.ok(taskService.markTaskInProgress(id));
    }
}
