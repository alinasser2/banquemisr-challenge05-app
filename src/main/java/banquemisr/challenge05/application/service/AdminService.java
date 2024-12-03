package banquemisr.challenge05.application.service;

import banquemisr.challenge05.application.dto.HistoryDto;
import banquemisr.challenge05.application.dto.NotificationDto;


import java.util.List;

public interface AdminService {

    List<NotificationDto> getAllNotifications(int pageNo, int pageSize, String sortBy);
    List<HistoryDto> getHistories(int pageNo, int pageSize, String sortBy);
}