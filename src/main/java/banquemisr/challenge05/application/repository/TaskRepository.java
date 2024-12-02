package banquemisr.challenge05.application.repository;

import banquemisr.challenge05.application.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.time.LocalDateTime;
import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<Task, UUID> {

    @Query("SELECT t FROM Task t WHERE " +
            "(:title IS NULL OR t.title LIKE %:title%) AND " +
            "(:description IS NULL OR t.description LIKE %:description%) AND " +
            "(:status IS NULL OR t.status = :status) AND " +
            "(:dueDate IS NULL OR t.dueDate = :dueDate)")
    Page<Task> searchTasks(
            @Param("title") String title,
            @Param("description") String description,
            @Param("status") Task.Status status,
            @Param("dueDate") LocalDateTime dueDate,
            Pageable pageable);

}
