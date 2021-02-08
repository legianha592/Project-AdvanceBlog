package vn.techmaster.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.techmaster.blog.model.Comment;
import vn.techmaster.blog.repository.CommentRepository;

import java.util.Optional;

@Service
public class CommentService implements ICommentService{
    @Autowired
    CommentRepository commentRepository;

    @Override
    public Optional<Comment> findById(Long Id) {
        return commentRepository.findById(Id);
    }

    @Override
    public void deleteById(Long Id) {
        commentRepository.deleteById(Id);
    }
}
