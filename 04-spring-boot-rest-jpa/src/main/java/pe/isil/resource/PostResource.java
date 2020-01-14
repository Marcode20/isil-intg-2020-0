package pe.isil.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.isil.model.Comment;
import pe.isil.model.Post;
import pe.isil.service.CommentService;
import pe.isil.service.PostService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostResource {

    @Autowired
    PostService postService;
    @Autowired
    CommentService commentService;

    @PostMapping("/posts")
    public ResponseEntity create(@RequestBody Post post){
        postService.save(post);
        return new ResponseEntity(post, HttpStatus.CREATED);
    }

    @PutMapping("/posts/{id}")
    public ResponseEntity update(@PathVariable Integer id,
                                 @RequestBody Post post){

        Post currentPost = postService.findById(id);
        if(currentPost == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        post.setId(id);
        postService.update(post);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/posts/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        Post currentPost = postService.findById(id);
        if(currentPost == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        postService.delete(currentPost);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/posts")
    public ResponseEntity findAll(){
        List<Post> posts = postService.findAll();
        if(posts == null){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity(posts, HttpStatus.OK);
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity findById(@PathVariable Integer id){
        Post currentPost = postService.findById(id);
        if(currentPost == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(currentPost, HttpStatus.OK);
    }


    // posts + comments

    @GetMapping("/posts/{postId}/comments")
    public ResponseEntity getCommentsByPostId(@PathVariable Integer postId){
        Post currentPost = postService.findById(postId);
        if(currentPost == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        List<Comment> comments = currentPost.getComments();
        if(comments == null){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity(comments, HttpStatus.OK);

    }

    @GetMapping("/posts/{postId}/comments/{commentId}")
    public ResponseEntity getCommentsByPostIdAndCommentId(@PathVariable Integer postId, @PathVariable Integer commentId){
        Post currentPost = postService.findById(postId);
        if(currentPost == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        List<Comment> comments = currentPost.getComments();
        if(comments == null){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }

        Comment comment = comments.stream()
                .filter(c -> commentId.equals(c.getId()))
                .findFirst()
                .orElse(null);

        if(comment == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(comment, HttpStatus.OK);
    }

    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity createComment(@PathVariable Integer postId,
                                        @RequestBody Comment comment){
        Post currentPost = postService.findById(postId);
        if(currentPost == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        comment.setPost(currentPost);
        commentService.save(comment);
        return new ResponseEntity(comment, HttpStatus.OK);
    }

    @PutMapping("/posts/{postId}/comments/{commentId}")
    public ResponseEntity updateComment(@PathVariable Integer postId,
                                        @PathVariable Integer commentId,
                                        @RequestBody Comment comment){
        Post currentPost = postService.findById(postId);
        if(currentPost == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        List<Comment> comments = currentPost.getComments();
        if(comments == null){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }

        Comment currentComment = comments.stream()
                .filter(c -> commentId.equals(c.getId()))
                .findFirst()
                .orElse(null);

        if(currentComment == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        commentService.update(comment);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/posts/{postId}/comments/{commentId}")
    public ResponseEntity deleteComment(@PathVariable Integer postId,
                                        @PathVariable Integer commentId){
        Post currentPost = postService.findById(postId);
        if(currentPost == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        List<Comment> comments = currentPost.getComments();
        if(comments == null){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }

        Comment currentComment = comments.stream()
                .filter(c -> commentId.equals(c.getId()))
                .findFirst()
                .orElse(null);

        if(currentComment == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        commentService.delete(currentComment);

        return new ResponseEntity(HttpStatus.OK);
    }
}
