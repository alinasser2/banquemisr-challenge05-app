package banquemisr.challenge05.application.mapper;

import banquemisr.challenge05.application.dto.TaskDTO;
import banquemisr.challenge05.application.entity.Task;
import banquemisr.challenge05.application.web.response.TaskResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface TaskMapper {


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    @Mapping(target = "status", source = "status")
    @Mapping(target = "priority", source = "priority")
    @Mapping(target = "dueDate", source = "dueDate")
    Task toEntity(TaskDTO dto);


    @Mapping(target = "status", source = "status")
    @Mapping(target = "priority", source = "priority")
    @Mapping(target = "dueDate", source = "dueDate")
    @Mapping(target = "createdAt", source = "createdAt")
    TaskResponseDTO toDto(Task task);

    void updateTaskFromDto(TaskDTO dto, @MappingTarget Task entity);
}
