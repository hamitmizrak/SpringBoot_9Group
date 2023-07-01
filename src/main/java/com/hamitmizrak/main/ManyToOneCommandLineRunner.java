package com.hamitmizrak.main;

import com.hamitmizrak.bean.ModelMapperBean;
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
import java.util.ArrayList;
import java.util.List;

// LOMBOK
@RequiredArgsConstructor

// Bean
@Configuration
public class ManyToOneCommandLineRunner {

    // INJECTION
    //@Autowired
    private final IBlogRepository iBlogRepository;
    private final ICategoryRepository iCategoryRepository;
    private final ModelMapperBean modelMapperBean;

    // Category Save
    @Transactional  // save,delete,create
    public CategoryEntity categorySave(String categoryName) {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setCategoryName(categoryName);
        iCategoryRepository.save(categoryEntity);
        return categoryEntity;
    }

    // Kullanıcıdan alınan kategoriyi eklesin
    public void userData() {
        for (int i = 1; i <= 4; i++) {
            String user = JOptionPane.showInputDialog("Lütfen category" + i + ". adını yazınız");
            user = user.toUpperCase();
            categorySave(user);
        }
    }

    // CATEGORY LIST
    public Iterable<CategoryEntity> categoryDtoList() {
        return iCategoryRepository.findAll();
    }

    // Bean
    @Bean
    @Transactional // save,delete,create
    public void manyToOneStatement() {
        // Tekilde Başla
        // Category(1) Blog(N)
        userData();
        Iterable<CategoryEntity> iterable = categoryDtoList();       // Iterable List
        List<CategoryEntity> categoryEntityList = new ArrayList<>(); // Normal List
        iterable.forEach(categoryEntityList::add);// Iterable List'i List Interface çeviriyor.

        // Blog(N)  Category(1)
        BlogEntity blog1 = new BlogEntity();
        blog1.setHeader("header-1");
        blog1.setContent("content-1");
        if(categoryEntityList!=null)
        blog1.setCategoryEntity(categoryEntityList.get(0));
        iBlogRepository.save(blog1);

        // Blog(N)  Category(1)
        //String header, String content, CategoryEntity categoryEntity)
        BlogEntity blog2 = new BlogEntity("header-1","content-1",categoryEntityList.get(1));
        iBlogRepository.save(blog2);

        // Göster (1) Category
        categoryEntityList.forEach(System.out::println); // Iterable çevrilmiş List görüyoruz.
        System.out.println(blog1);
        System.out.println(blog2);
    }

    // CommandLineRunner
    public CommandLineRunner manyToOneResult() {
        return (args) -> {
            manyToOneStatement();
        }; //end return
    }  //end CommandLineRunner
}//enc class
