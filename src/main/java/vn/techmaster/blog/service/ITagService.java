package vn.techmaster.blog.service;

import vn.techmaster.blog.model.Post;

import java.util.List;

public interface ITagService {
    public List<Post> getAllPostsByTagId(Long tag_id);
}
