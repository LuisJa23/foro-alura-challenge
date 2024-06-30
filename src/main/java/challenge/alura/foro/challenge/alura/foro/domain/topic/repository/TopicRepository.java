package challenge.alura.foro.challenge.alura.foro.domain.topic.repository;

import challenge.alura.foro.challenge.alura.foro.domain.topic.model.Topic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {
    Page<Topic> findAllByStatusTrue(Pageable pageable);

    @Modifying
    @Query("DELETE FROM Topic t WHERE t.id = :id")
    int deleteTopicById(Long id);
}
