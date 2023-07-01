package com.hamitmizrak.controller.mvc;

import com.hamitmizrak.business.dto.BlogsDto;

import java.util.List;

public  interface IBlogMvc<T> {

    //CRUD
    public BlogsDto create(T t);
    public BlogsDto delete(T t);
    public BlogsDto update(Long id, T t);
    public List<BlogsDto> list();
}
