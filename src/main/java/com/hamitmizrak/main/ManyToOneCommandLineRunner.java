package com.hamitmizrak.main;

import com.hamitmizrak.data.entity.BlogEntity;
import com.hamitmizrak.data.entity.CategoryEntity;
import com.hamitmizrak.data.repository.IBlogRepository;
import com.hamitmizrak.data.repository.ICategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

// LOMBOK
@RequiredArgsConstructor

@Configuration
public class ManyToOneCommandLineRunner {

    //@Autowired
    private final IBlogRepository iBlogRepository;
    private final ICategoryRepository iCategoryRepository;


    // Bean
    @Bean
    @Transactional // save,delete,create
    public void manyToOneStatement(){
        // Tekilde Başla
        // Blog(1) Category(N)
        BlogEntity blog=new BlogEntity();
        blog.setHeader("header-1");
        blog.setContent("content-1");
        iBlogRepository.save(blog);

        // Category(N) Blog(1)
        CategoryEntity category1=new CategoryEntity();
        category1.setCategoryName("bilişim");
        category1.setBlogEntity(blog);
        iCategoryRepository.save(category1);

        CategoryEntity category2=new CategoryEntity();
        category2.setCategoryName("java");
        category2.setBlogEntity(blog);
        iCategoryRepository.save(category2);
    }

    // CommandLineRunner
    public CommandLineRunner manyToOneResult(){
        return (args)->{
            manyToOneStatement();
        };
    }  //end CommandLineRunner

}//enc class
