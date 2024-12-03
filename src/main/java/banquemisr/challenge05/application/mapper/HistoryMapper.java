package banquemisr.challenge05.application.mapper;

import banquemisr.challenge05.application.dto.HistoryDto;
import banquemisr.challenge05.application.entity.History;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring", // Ensures Spring creates the mapper instance
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE // Avoids overwriting null values
)
public interface HistoryMapper {

    @Mapping(source = "actionType", target = "actionType")
    @Mapping(source = "task", target = "task")
    @Mapping(source = "CreatedAt", target = "CreatedAt")
    HistoryDto toDto(History history);

    @Mapping(source = "actionType", target = "actionType")
    @Mapping(source = "task", target = "task")
    @Mapping(source = "CreatedAt", target = "CreatedAt")
    History toEntity(HistoryDto historyDto);
}