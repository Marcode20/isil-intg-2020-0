package pe.isil.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.isil.model.Comment;
import pe.isil.service.CommentService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CommentResource {

    @Autowired
    CommentService commentService;

    @PostMapping("/comments")
    public ResponseEntity create(@RequestBody Comment comment){
        commentService.save(comment);
        return new ResponseEntity(comment, HttpStatus.CREATED);
    }

    @PutMapping("/comments/{id}")
    public ResponseEntity update(@PathVariable Integer id,
                                 @RequestBody Comment comment){

        Comment currentComment = commentService.findById(id);
        if(currentComment == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        comment.setId(id);
        commentService.update(comment);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/comments/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        Comment currentPost = commentService.findById(id);
        if(currentPost == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        commentService.delete(currentPost);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/comments")
    public ResponseEntity findAll(){
        List<Comment> comments = commentService.findAll();
        if(comments == null){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity(comments, HttpStatus.OK);
    }

    @GetMapping("/comments/{id}")
    public ResponseEntity findById(@PathVariable Integer id){
        Comment currentComment = commentService.findById(id);
        if(currentComment == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(currentComment, HttpStatus.OK);
    }
}
