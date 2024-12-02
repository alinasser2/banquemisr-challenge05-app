package banquemisr.challenge05.application.config;


import banquemisr.challenge05.application.mapper.TaskMapper;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapStructConfiguration {

    public TaskMapper taskMapper() {
        return new TaskMapperImpl();
    }

}
