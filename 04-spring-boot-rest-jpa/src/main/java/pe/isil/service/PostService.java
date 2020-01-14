package pe.isil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.model.Post;
import pe.isil.repository.PostRepository;

import java.util.List;

@Service
public class PostService implements BaseService<Post, Integer> {

    @Autowired
    PostRepository postRepository;


    @Override
    public void save(Post post) {
        postRepository.save(post);
    }

    @Override
    public void update(Post post) {
        postRepository.save(post);
    }

    @Override
    public void delete(Post post) {
        postRepository.delete(post);
    }

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Post findById(Integer id) {
        return postRepository.findById(id)
                .orElseGet(null);
    }
}
