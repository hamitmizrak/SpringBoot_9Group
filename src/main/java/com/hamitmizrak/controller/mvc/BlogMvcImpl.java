package com.hamitmizrak.controller.mvc;

import com.hamitmizrak.business.dto.BlogDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public  class BlogMvcImpl implements IBlogMvc<BlogDto> {

    // CREATE
    @Override
    public BlogDto create(BlogDto blogDto) {
        return null;
    }

    // DELETE
    @Override
    public BlogDto delete(BlogDto blogDto) {
        return null;
    }

    // UPDATE
    @Override
    public BlogDto update(Long id, BlogDto blogDto) {
        return null;
    }

    //LIST
    @Override
    public List<BlogDto> list() {
        return null;
    }

    // Tutorials
    // http://localhost:4444/getData0
    @GetMapping("/getData0")
    @ResponseBody
    public String getThymeleaf0(){
        return "Sayfasız data";
    }

    // http://localhost:4444/getData1
    @GetMapping("/getData1")
    public String getThymeleaf1(){
        return "page1";
    }

    // http://localhost:4444/getData2
    @GetMapping("/getData2")
    public String getThymeleaf2(Model model){
        model.addAttribute("key2","String data");
        return "page2";
    }

    // http://localhost:4444/getData3
    @GetMapping("/getData3")
    public String getThymeleaf3(Model model){
        BlogDto blogDto=new BlogDto();
        blogDto.setId(1L);
        blogDto.setHeader("Header");
        blogDto.setContent("Content");
        model.addAttribute("key3",blogDto);
        return "page3";
    }

    // http://localhost:4444/getData4
    // http://localhost:4444/getData4/0
    // http://localhost:4444/getData4/1
    @GetMapping({"/getData4","/getData4/{id}"})
    public String getThymeleaf4(@PathVariable(name="id",required = false) Long id, Model model){
        BlogDto blogDto=new BlogDto();
        blogDto.setId(id);
        blogDto.setHeader("Header");
        blogDto.setContent("Content");

        if(blogDto.getId()==0){
            model.addAttribute("key4","Bad Request");
        }else if(blogDto.getId()==null){
            model.addAttribute("key4","NotFound Exception");
        }else{
            model.addAttribute("key4",blogDto);
        }
        return "page4";
    }

}
