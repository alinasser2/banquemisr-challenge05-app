package banquemisr.challenge05.application.mapper;

import banquemisr.challenge05.application.dto.TaskDTO;
import banquemisr.challenge05.application.entity.Task;
import banquemisr.challenge05.application.web.response.TaskResponseDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-03T00:56:45+0200",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.13 (Amazon.com Inc.)"
)
@Component
public class TaskMapperImpl implements TaskMapper {

    @Override
    public Task toEntity(TaskDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Task task = new Task();

        if ( dto.getStatus() != null ) {
            task.setStatus( Enum.valueOf( Task.Status.class, dto.getStatus() ) );
        }
        task.setPriority( dto.getPriority() );
        task.setDueDate( dto.getDueDate() );
        task.setTitle( dto.getTitle() );
        task.setDescription( dto.getDescription() );

        return task;
    }

    @Override
    public TaskResponseDTO toDto(Task task) {
        if ( task == null ) {
            return null;
        }

        TaskResponseDTO taskResponseDTO = new TaskResponseDTO();

        return taskResponseDTO;
    }

    @Override
    public void updateTaskFromDto(TaskDTO dto, Task entity) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getTitle() != null ) {
            entity.setTitle( dto.getTitle() );
        }
        if ( dto.getDescription() != null ) {
            entity.setDescription( dto.getDescription() );
        }
        if ( dto.getStatus() != null ) {
            entity.setStatus( Enum.valueOf( Task.Status.class, dto.getStatus() ) );
        }
        if ( dto.getPriority() != null ) {
            entity.setPriority( dto.getPriority() );
        }
        if ( dto.getDueDate() != null ) {
            entity.setDueDate( dto.getDueDate() );
        }
    }
}
