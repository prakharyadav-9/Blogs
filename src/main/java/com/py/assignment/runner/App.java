package com.py.assignment.runner;

import java.util.List;

import com.py.assignment.runner.model.Blog;
import com.py.assignment.runner.operations.BlogOpr;
import com.py.assignment.runner.utils.Utils;

/**
 * Hello world!
 *
 */
public class App {
	
    public static void main( String[] args ){
        System.out.println( "Hello World!" );
//        Scanner sc = new Scanner(System.in);
        BlogOpr blogOpr = new BlogOpr();
		Blog blog= blogOpr.createBlog("AnonymousUser", "BITS is a good college. Our life is great");
//		blogOpr.saveBlog(blog);
		System.out.println();;

        List<Blog> blogs = blogOpr.getAllBlogs();
        for(Blog blog1: blogs) {
        	System.out.println(blog1.getName() + " | " + blog1.getBlog() + " | "+ blog1.getTimeStamp() + " ;;");
        	
        }
        
        System.out.println( "---------Exiting-----------" );
        
    }
}
