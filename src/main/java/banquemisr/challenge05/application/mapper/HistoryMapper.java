package banquemisr.challenge05.application.mapper;

import banquemisr.challenge05.application.dto.HistoryDto;
import banquemisr.challenge05.application.entity.History;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface HistoryMapper {

    // Map History entity to HistoryDto
    @Mapping(source = "actionType", target = "actionType")
    @Mapping(source = "task", target = "task")
    @Mapping(source = "createdAt", target = "createdAt")
    HistoryDto toDto(History history);

    // Map HistoryDto back to History entity
    @Mapping(source = "actionType", target = "actionType")
    @Mapping(source = "task", target = "task")  // Map TaskDto to Task
    @Mapping(source = "createdAt", target = "createdAt")
    History toEntity(HistoryDto historyDto);
}
