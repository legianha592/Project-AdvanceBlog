package vn.techmaster.blog.service;

import vn.techmaster.blog.model.Comment;

import java.util.Optional;

public interface ICommentService {
    public Optional<Comment> findById(Long Id);

    public void deleteById(Long Id);
}
