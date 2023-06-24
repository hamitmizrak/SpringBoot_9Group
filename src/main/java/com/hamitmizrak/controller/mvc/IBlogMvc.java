package com.hamitmizrak.controller.mvc;

import com.hamitmizrak.business.dto.BlogDto;

import java.util.List;

public  interface IBlogMvc<T> {

    //CRUD
    public BlogDto create(T t);
    public BlogDto delete(T t);
    public BlogDto update(Long id,T t);
    public List<BlogDto> list();
}
