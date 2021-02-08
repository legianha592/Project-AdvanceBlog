package vn.techmaster.blog.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import vn.techmaster.blog.model.Post;
import vn.techmaster.blog.model.Tag;

@Repository
public interface TagRepository extends JpaRepository <Tag, Long>{

    @Query(value = "SELECT post_id FROM post_tag AS p WHERE p.tag_id = :tag_id",
            nativeQuery = true)
    public List<Long> getAllPostIdByTagId(@Param("tag_id") long tag_id);
}