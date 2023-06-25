package com.hamitmizrak.main;

import com.hamitmizrak.bean.ModelMapperBean;
import com.hamitmizrak.business.dto.CategoryDto;
import com.hamitmizrak.data.entity.BlogEntity;
import com.hamitmizrak.data.entity.CategoryEntity;
import com.hamitmizrak.data.repository.IBlogRepository;
import com.hamitmizrak.data.repository.ICategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.*;

// LOMBOK
@RequiredArgsConstructor

@Configuration
public class ManyToOneCommandLineRunner {

    // INJECTION
    //@Autowired
    private final IBlogRepository iBlogRepository;
    private final ICategoryRepository iCategoryRepository;
    private final ModelMapperBean modelMapperBean;


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
        String user= JOptionPane.showInputDialog("Lütfen category adını yazınız");
        user=user.toUpperCase();
        category1.setCategoryName(user);
        category1.setBlogEntity(blog);
        iCategoryRepository.save(category1);

        CategoryEntity category2=new CategoryEntity();
        String user2= JOptionPane.showInputDialog("Lütfen category adını yazınız");
        user2=user2.toUpperCase();
        category2.setCategoryName(user2);
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
