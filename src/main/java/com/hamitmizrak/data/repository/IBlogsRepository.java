package com.hamitmizrak.data.repository;

import com.hamitmizrak.data.entity.BlogsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// http://localhost:2222/h2-console
@Repository
public interface IBlogsRepository extends CrudRepository<BlogsEntity,Long> {

    // Delivered Query
    BlogsEntity findBlogEntityByHeader(String header);
    // @Query
}
