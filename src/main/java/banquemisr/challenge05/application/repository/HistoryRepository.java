package banquemisr.challenge05.application.repository;

import banquemisr.challenge05.application.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;


@Repository
public interface HistoryRepository extends JpaRepository<History, UUID> {
}
