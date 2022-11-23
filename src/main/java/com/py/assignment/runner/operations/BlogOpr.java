package com.py.assignment.runner.operations;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.inject.Inject;

import com.py.assignment.runner.model.Blog;
import com.py.assignment.runner.mysql.connector.Connection;
import com.py.assignment.runner.mysql.dao.operations.BlogDAO;
import com.py.assignment.runner.utils.Utils;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BlogOpr {
	
	@Inject Utils utils;
	@Inject BlogDAO blogDao;
	
	public BlogOpr() {
		this.blogDao = new BlogDAO(new Connection());
		this.utils = new Utils();
	}
	
	public BlogOpr(Utils utils) {
		this.utils = utils;
	}
	public BlogOpr(Utils utils, BlogDAO blogDao) {
		this.utils = new Utils();
		this.blogDao = new BlogDAO(new Connection());
	}
	
	public Blog createBlog(String name, String content) {
		Blog blog = new Blog();
		blog.setName(utils.changeUpper(name));
		blog.setBlog(content);
		blog.setTimeStamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
//		System.out.println(blog);
		return blog;
	}
	
	public Blog saveBlog(Blog blog) {
//		System.out.println(this.blogDao);
		return blogDao.saveBlog(blog);
//		return blog;
	}
	
	public List<Blog> getAllBlogs(){
		List<Blog> blogs =this.blogDao.getAllBlogs();
		return blogs;
	}

}
