package banquemisr.challenge05.application.mapper;

import banquemisr.challenge05.application.dto.TaskDTO;
import banquemisr.challenge05.application.entity.Task;
import banquemisr.challenge05.application.web.response.TaskResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring", // Ensures Spring creates the mapper instance
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE // Avoids overwriting null values
)
public interface TaskMapper {


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    @Mapping(target = "status", source = "status")  // Ensure 'status' is properly mapped
    @Mapping(target = "priority", source = "priority")  // Map 'priority' from TaskDTO to Task
    @Mapping(target = "dueDate", source = "dueDate")  // Map 'dueDate' from TaskDTO to Task
    Task toEntity(TaskDTO dto);


    @Mapping(target = "status", source = "status")  // Ensure 'status' is properly mapped
    @Mapping(target = "priority", source = "priority")  // Map 'priority' from Task to TaskResponseDTO
    @Mapping(target = "dueDate", source = "dueDate")  // Map 'dueDate' from Task to TaskResponseDTO
    @Mapping(target = "createdAt", source = "createdAt")  // Map 'createdAt' from Task to TaskResponseDTO
    TaskResponseDTO toDto(Task task);

    // Update an existing Task entity with new values from TaskDTO
    void updateTaskFromDto(TaskDTO dto, @MappingTarget Task entity);
}
