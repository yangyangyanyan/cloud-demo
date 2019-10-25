package com.example.service;

import com.example.bean.Blog;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service   //feign的熔断器需要交给ioc的容器管路，因此需要添加注解
public class BlogServiceFallBack implements BlogService {
    @Override
    public Blog findByTitle(String title) {
        return new Blog("服务器挂了","");
    }

    @Override
    public List<Blog> findList() {
        return new ArrayList<>();
    }
}
