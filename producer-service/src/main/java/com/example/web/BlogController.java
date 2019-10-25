package com.example.web;

import com.example.bean.Blog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
public class BlogController {
    @RequestMapping("/blog/{title}")
    public Blog findByTitle(@PathVariable("title") String title){
        return new Blog(title,"一一一");

    }
    @RequestMapping("/blog/findList")
    public List<Blog> findList(){
        List<Blog> list=new ArrayList<>();
        list.add(new Blog("博客一","作者一"));
        list.add(new Blog("博客二","作者二"));
        list.add(new Blog("博客三","作者三"));
        list.add(new Blog("博克四","作者四"));
        return list;
    }
}
