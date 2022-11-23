package com.py.assignment.runner.model;

public class Blog {
	private String name, blog, timeStamp;

	public String getTimeStamp() {
		return timeStamp;
	}


	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public String getBlog() {
		return blog;
	}

	public void setBlog(String blog) {
		this.blog = blog;
	}

	@Override
	public String toString() {
		return "Blog [name=" + name + ", blog=" + blog + ", timeStamp=" + timeStamp + "]";
	}


}
