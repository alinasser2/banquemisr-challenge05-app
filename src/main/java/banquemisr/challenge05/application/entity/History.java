package banquemisr.challenge05.application.entity;

import banquemisr.challenge05.application.enums.ActionType;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ActionType actionType;

    @ManyToOne
    @JoinColumn(name = "task_id" , nullable = false)
    private Task task;

    @Column(nullable = false)
    private Date CreatedAt;
}
