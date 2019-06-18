package com.learning.basic;

import org.springframework.beans.factory.annotation.Autowired;

public class classA {
	classBInterface b;
	public classA() {
		// TODO Auto-generated constructor stub
	}
public classBInterface getB() {
		return b;
	}

    @Autowired
	public void setB(classBInterface b) {
		this.b = b;
	}
	public void methodA()
	{
		System.out.println("Method A");
		System.out.println(b.methodB());
	}
	public void init()
	{
		System.out.println("class A initialized "+ this);
		
	}

}
