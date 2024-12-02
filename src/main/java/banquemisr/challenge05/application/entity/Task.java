package banquemisr.challenge05.application.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import java.time.LocalDateTime;
import java.util.UUID;



@Data
@Entity
@SQLDelete(sql = "UPDATE task SET deleted_at = NOW() WHERE id = ?")
@Where(clause = "deleted_at IS NULL")
public class Task {

    @Id
    @GeneratedValue
    private UUID id;  // UUID as the primary key

    @Column(nullable = false)
    private String title;

    @Column(length = 500)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status = Status.TODO;

    @Column(nullable = false)
    private Integer priority;  // 1 = High, 2 = Medium, 3 = Low

    private LocalDateTime dueDate;

    @CreationTimestamp
    private LocalDateTime createdAt;

    private LocalDateTime deletedAt;
    // Enum for task status
    public enum Status {
        TODO,
        IN_PROGRESS,
        DONE
    }
}
