package com.hamitmizrak.controller.mvc;

import com.hamitmizrak.business.dto.BlogsDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
public  class BlogMvcImpl implements IBlogMvc<BlogsDto> {

    // CREATE
    @Override
    public BlogsDto create(BlogsDto blogDto) {
        return null;
    }

    // DELETE
    @Override
    public BlogsDto delete(BlogsDto blogDto) {
        return null;
    }

    // UPDATE
    @Override
    public BlogsDto update(Long id, BlogsDto blogDto) {
        return null;
    }

    //LIST
    @Override
    public List<BlogsDto> list() {
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
        BlogsDto blogDto=new BlogsDto();
        blogDto.setBlogId(1L);
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
        BlogsDto blogDto=new BlogsDto();
        blogDto.setBlogId(id);
        blogDto.setHeader("Header");
        blogDto.setContent("Content");
        if(blogDto.getBlogId()==0){
            model.addAttribute("key4","Bad Request");
        }else if(blogDto.getBlogId()==null){
            model.addAttribute("key4","NotFound Exception");
        }else{
            model.addAttribute("key4",blogDto);
        }
        return "page4";
    }


    // http://localhost:4444/getData5?id=5
    @GetMapping("/getData5")
    public String getThymeleaf5(@RequestParam(name="id",required = false,defaultValue ="1" ) Long id, Model model){
        BlogsDto blogDto=new BlogsDto();
        blogDto.setBlogId(id);
        blogDto.setHeader("Header");
        blogDto.setContent("Content");
        if(blogDto.getBlogId()==0){
            model.addAttribute("key4","Bad Request");
        }else if(blogDto.getBlogId()==null){
            model.addAttribute("key4","NotFound Exception");
        }else{
            model.addAttribute("key4",blogDto);
        }
        return "page4";
    }

}
