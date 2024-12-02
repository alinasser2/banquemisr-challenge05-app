package banquemisr.challenge05.application.mapper;

import banquemisr.challenge05.application.dto.TaskRequestDTO;
import banquemisr.challenge05.application.entity.Task;
import banquemisr.challenge05.application.response.TaskResponseDTO;
import org.mapstruct.Mapper;


@Mapper
public interface TaskMapper {

    @Mapping(target = "id", ignore = true) // Ignore ID since it's auto-generated
    @Mapping(target = "createdAt", ignore = true) // Created at is auto-handled
    @Mapping(target = "deletedAt", ignore = true) // Soft delete handled separately
    Task toEntity(TaskRequestDTO dto);

    TaskResponseDTO toDto(Task task);
}
