package vn.techmaster.blog.DTO;

import java.util.HashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import vn.techmaster.blog.controller.request.PostRequest;
import vn.techmaster.blog.model.Post;
import vn.techmaster.blog.model.Tag;
import vn.techmaster.blog.model.User;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-02-25T19:46:49+0700",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 14.0.2 (Oracle Corporation)"
)
public class PostMapperImpl implements PostMapper {

    @Override
    public Post postRequestToPost(PostRequest postRequest) {
        if ( postRequest == null ) {
            return null;
        }

        Post post = new Post();

        post.setId( postRequest.getId() );
        post.setTitle( postRequest.getTitle() );
        post.setContent( postRequest.getContent() );
        Set<Tag> set = postRequest.getTags();
        if ( set != null ) {
            post.setTags( new HashSet<Tag>( set ) );
        }

        return post;
    }

    @Override
    public PostRequest postToPostRequest(Post post) {
        if ( post == null ) {
            return null;
        }

        PostRequest postRequest = new PostRequest();

        postRequest.setUser_id( postUserId( post ) );
        postRequest.setId( post.getId() );
        postRequest.setTitle( post.getTitle() );
        postRequest.setContent( post.getContent() );
        Set<Tag> set = post.getTags();
        if ( set != null ) {
            postRequest.setTags( new HashSet<Tag>( set ) );
        }

        return postRequest;
    }

    @Override
    public PostPOJO postToPostPOJO(Post post) {
        if ( post == null ) {
            return null;
        }

        PostPOJO postPOJO = new PostPOJO();

        postPOJO.setUser_id( postUserId( post ) );
        postPOJO.setUserFullName( postUserFullname( post ) );
        postPOJO.setId( post.getId() );
        postPOJO.setTitle( post.getTitle() );
        postPOJO.setContent( post.getContent() );
        postPOJO.setLastUpdate( post.getLastUpdate() );

        return postPOJO;
    }

    private Long postUserId(Post post) {
        if ( post == null ) {
            return null;
        }
        User user = post.getUser();
        if ( user == null ) {
            return null;
        }
        long id = user.getId();
        return id;
    }

    private String postUserFullname(Post post) {
        if ( post == null ) {
            return null;
        }
        User user = post.getUser();
        if ( user == null ) {
            return null;
        }
        String fullname = user.getFullname();
        if ( fullname == null ) {
            return null;
        }
        return fullname;
    }
}
