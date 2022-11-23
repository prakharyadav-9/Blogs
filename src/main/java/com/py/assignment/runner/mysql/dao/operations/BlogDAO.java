package com.py.assignment.runner.mysql.dao.operations;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import com.google.gson.Gson;
import com.mysql.cj.xdevapi.Collection;
import com.mysql.cj.xdevapi.DbDoc;
import com.mysql.cj.xdevapi.DocResult;
import com.py.assignment.runner.model.Blog;
import com.py.assignment.runner.mysql.connector.Connection;

public class BlogDAO {

	private Connection connection;
	public BlogDAO(Connection connection) {
		this.connection = connection;
	}
	
	public Blog saveBlog(Blog blog) {
		Collection collection = this.connection.getConnection("logs");
		collection.add(new Gson().toJson(blog)).execute();
		this.connection.closeCLient();
		return blog;
	}
	
	
	public List<Blog> getAllBlogs(){
		List<Blog> blogs = new ArrayList<>();
		Gson gson = new Gson();
		Collection collection = this.connection.getConnection("logs");
		CompletableFuture<DocResult> docs= collection.find().orderBy("$.timeStamp desc").executeAsync();
		try {
			DocResult docRes =  docs.get();
			for(DbDoc doc : docRes) {
				blogs.add(gson.fromJson(doc.toFormattedString(), Blog.class));
			}
		} catch (InterruptedException | ExecutionException e) {
			System.err.print("Could not fetch all data = "+ e);
			e.printStackTrace();
		}
		return blogs;
	}
	
}
