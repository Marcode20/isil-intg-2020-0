package pe.isil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.isil.model.Comment;

@Repository
public interface CommentRepository
        extends JpaRepository<Comment, Integer> {
}
