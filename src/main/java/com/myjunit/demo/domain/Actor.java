package com.myjunit.demo.domain;

import java.io.Serializable;

public class Actor implements Serializable {
	private static final long serialVersionUID = 1L;

	String name;
	
	Integer age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Actor [name=" + name + ", age=" + age + "]";
	}
	
}
