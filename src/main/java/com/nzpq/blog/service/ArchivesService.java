package com.nzpq.blog.service;

import com.nzpq.blog.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface ArchivesService {

    Map<String, List<Blog>> archiveBlog();

    Long countBlog();
}
