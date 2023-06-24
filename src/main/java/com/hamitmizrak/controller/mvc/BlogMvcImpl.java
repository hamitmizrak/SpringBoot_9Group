package com.hamitmizrak.controller.mvc;

import com.hamitmizrak.business.dto.BlogDto;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
    // http://localhost:2222/getdata0
    @GetMapping("/getdata0")
    @ResponseBody
    public String getThymeleaf0(){
        return "Sayfasız data";
    }

    // http://localhost:2222/getdata1
    @GetMapping("/getdata1")
    public String getThymeleaf1(){
        return "page1";
    }

    // http://localhost:2222/getdata2
    @GetMapping("/getdata2")
    public String getThymeleaf2(Model model){
        model.addAttribute("key2","String data");
        return "page2";
    }

    // http://localhost:2222/getdata2
    @GetMapping("/getdata3")
    public String getThymeleaf3(Model model){
        BlogDto blogDto=new BlogDto();
        blogDto.setId(1L);
        blogDto.setHeader("Header");
        blogDto.setContent("Content");
        model.addAttribute("key3",blogDto);
        return "page3";
    }
}
