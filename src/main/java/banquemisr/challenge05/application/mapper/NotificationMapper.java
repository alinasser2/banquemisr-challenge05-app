package banquemisr.challenge05.application.mapper;

import banquemisr.challenge05.application.dto.NotificationDto;
import banquemisr.challenge05.application.entity.Notification;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;


@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface NotificationMapper {

    @Mapping(source = "to", target = "to")
    @Mapping(source = "subject", target = "subject")
    @Mapping(source = "createdAt", target = "createdAt")
    NotificationDto toDto(Notification notification);

    @Mapping(source = "to", target = "to")
    @Mapping(source = "subject", target = "subject")
    @Mapping(source = "createdAt", target = "createdAt")
    Notification toEntity(NotificationDto notificationDto);
}
