package banquemisr.challenge05.application.service.serviceImpl;

import banquemisr.challenge05.application.dto.HistoryDto;
import banquemisr.challenge05.application.dto.NotificationDto;
import banquemisr.challenge05.application.mapper.HistoryMapper;
import banquemisr.challenge05.application.mapper.NotificationMapper;
import banquemisr.challenge05.application.repository.HistoryRepository;
import banquemisr.challenge05.application.repository.NotificationRepository;
import banquemisr.challenge05.application.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private HistoryRepository historyRepository;

    @Autowired
    private NotificationMapper notificationMapper;

    @Autowired
    private HistoryMapper historyMapper;

    @Override
    public List<NotificationDto> getAllNotifications(int pageNo, int pageSize, String sortBy) {
        return notificationRepository.findAll()
                .stream()
                .map(notificationMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<HistoryDto> getHistories(int pageNo, int pageSize, String sortBy) {
        return historyRepository.findAll()
                .stream()
                .map(historyMapper::toDto)
                .collect(Collectors.toList());
    }
}
