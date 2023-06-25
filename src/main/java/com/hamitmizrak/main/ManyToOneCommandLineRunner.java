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

    // Category Save
    @Transactional  // save,delete,create
    public CategoryEntity categorySave(String categoryName){
        CategoryEntity categoryEntity=new CategoryEntity();
        categoryEntity.setCategoryName(categoryName);
        iCategoryRepository.save(categoryEntity);
        return categoryEntity;
    }

    // Kullanıcıdan alınan kategoriyi eklesin
    public void userData(){
        for (int i = 1; i <=4; i++) {
            String user= JOptionPane.showInputDialog("Lütfen category"+ i+". adını yazınız");
            user=user.toUpperCase();
            categorySave(user);
        }
    }

    // CATEGORY LIST
    public Iterable<CategoryEntity> categoryDtoList(){
        return iCategoryRepository.findAll();
    }

    // Bean
    @Bean
    @Transactional // save,delete,create
    public void manyToOneStatement(){
        // Tekilde Başla
        // Category(1) Blog(N)
         userData();
         Iterable<CategoryEntity> dtoList=categoryDtoList();

        // Blog(N)  Category(1)
        BlogEntity blog1=new BlogEntity();
        blog1.setHeader("header-1");
        blog1.setContent("content-1");
        blog1.setCategoryEntity(dtoList.get(0),CategoryEntity.class);
        iBlogRepository.save(blog1);

        // Blog(N)  Category(1)
        BlogEntity blog2=new BlogEntity();
        blog2.setHeader("header-1");
        blog2.setContent("content-1");
        blog2.setCategoryEntity(dtoList.get(1),CategoryEntity.class);
        iBlogRepository.save(blog2);
    }

    // CommandLineRunner
    public CommandLineRunner manyToOneResult(){
        return (args)->{
            manyToOneStatement();
        };
    }  //end CommandLineRunner

}//enc class
