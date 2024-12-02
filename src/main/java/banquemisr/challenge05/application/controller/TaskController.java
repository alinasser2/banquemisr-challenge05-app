package banquemisr.challenge05.application.controller;

import banquemisr.challenge05.application.dto.TaskDTO;
import banquemisr.challenge05.application.response.TaskResponseDTO;
import banquemisr.challenge05.application.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/tasks")
@Api(tags = "Task Management")
public class TaskController {

    @Autowired
    private TaskService taskService;


    @PostMapping
    @ApiOperation(value = "Create a new task")
    public ResponseEntity<TaskResponseDTO> createTask(@RequestBody TaskDTO taskRequest) {
        return ResponseEntity.ok(taskService.createTask(taskRequest));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update an existing task")
    public ResponseEntity<TaskResponseDTO> updateTask(@PathVariable UUID id, @RequestBody TaskDTO taskRequest) {
        return ResponseEntity.ok(taskService.updateTask(id, taskRequest));
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get a task by ID")
    public ResponseEntity<TaskResponseDTO> getTaskById(@PathVariable UUID id) {
        return ResponseEntity.ok(taskService.getTaskById(id));
    }

    @GetMapping
    @ApiOperation(value = "Get all tasks")
    public ResponseEntity<List<TaskResponseDTO>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete a task by ID")
    public ResponseEntity<Void> deleteTask(@PathVariable UUID id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
