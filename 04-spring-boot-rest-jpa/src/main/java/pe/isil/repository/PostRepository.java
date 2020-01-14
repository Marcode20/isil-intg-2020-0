package pe.isil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.isil.model.Post;

@Repository
public interface PostRepository
        extends JpaRepository<Post, Integer> {
}
