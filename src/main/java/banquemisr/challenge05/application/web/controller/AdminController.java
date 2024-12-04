package banquemisr.challenge05.application.web.controller;

import banquemisr.challenge05.application.dto.HistoryDto;
import banquemisr.challenge05.application.dto.NotificationDto;
import banquemisr.challenge05.application.service.AdminService;
import banquemisr.challenge05.application.utils.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/notifications")
    public List<NotificationDto> getAllNotifications(
            @RequestParam(defaultValue = "" + AppConstants.DEFAULT_PAGE_NUMBER) int pageNo,
            @RequestParam(defaultValue = "" + AppConstants.DEFAULT_PAGE_SIZE) int pageSize,
            @RequestParam(defaultValue = "createdAt") String sortBy
    ) {
        return adminService.getAllNotifications(pageNo, pageSize, sortBy);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/histories")
    public List<HistoryDto> getHistories(
            @RequestParam(defaultValue = "" + AppConstants.DEFAULT_PAGE_NUMBER) int pageNo,
            @RequestParam(defaultValue = "" + AppConstants.DEFAULT_PAGE_SIZE) int pageSize,
            @RequestParam(defaultValue = "createdAt") String sortBy
    ) {
        return adminService.getHistories(pageNo, pageSize, sortBy);
    }
}
