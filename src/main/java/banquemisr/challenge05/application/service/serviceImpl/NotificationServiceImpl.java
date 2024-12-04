package banquemisr.challenge05.application.service.serviceImpl;

import banquemisr.challenge05.application.entity.Notification;
import banquemisr.challenge05.application.entity.User;
import banquemisr.challenge05.application.enums.ErrorMessage;
import banquemisr.challenge05.application.exception.ResourceNotFoundException;
import banquemisr.challenge05.application.repository.NotificationRepository;
import banquemisr.challenge05.application.repository.UserRepository;
import banquemisr.challenge05.application.service.NotificationService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class NotificationServiceImpl implements NotificationService {

    private final JavaMailSender mailSender;
    private final UserRepository userRepository;
    private final NotificationRepository notificationRepository;

    public NotificationServiceImpl(JavaMailSender mailSender , UserRepository userRepository , NotificationRepository notificationRepository) {
        this.mailSender = mailSender;
        this.userRepository = userRepository;
        this.notificationRepository = notificationRepository;
    }

    @Override
    public void sendEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        message.setFrom("bar@gmail.com");
        mailSender.send(message);
        String currentUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(currentUserEmail)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorMessage.RESOURCE_NOT_FOUND));
        Notification notification = Notification.builder()
                .to(user)
                .subject(subject)
                .createdAt(new Date())
                .build();
        notificationRepository.save(notification);
    }

}