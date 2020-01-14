package pe.isil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.model.Comment;
import pe.isil.repository.CommentRepository;

import java.util.List;

@Service
public class CommentService implements BaseService<Comment, Integer> {

    @Autowired
    CommentRepository commentRepository;

    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void update(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void delete(Comment comment) {
        commentRepository.delete(comment);
    }

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment findById(Integer id) {
        return commentRepository.findById(id).orElseGet(null);
    }
}
