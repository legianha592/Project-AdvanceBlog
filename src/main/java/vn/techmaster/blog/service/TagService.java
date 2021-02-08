package vn.techmaster.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.techmaster.blog.model.Post;
import vn.techmaster.blog.repository.PostRepository;
import vn.techmaster.blog.repository.TagRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagService implements ITagService{
    @Autowired
    TagRepository tagRepository;

    @Autowired
    PostRepository postRepository;

    @Override
    public List<Post> getAllPostsByTagId(Long tag_id) {
        List<Post> finalList = new ArrayList<>();
        List<Long> listId = tagRepository.getAllPostIdByTagId(tag_id);

        System.out.println("list id = ");
        for (Long id : listId){
            System.out.println("id = " + id);
        }

        for (Long id : listId){
            for (Post post : postRepository.findAll()){
                if (post.getId() == id){
                    finalList.add(post);
                    break;
                }
            }
        }

        return finalList;
    }
}
