package com.learning.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.learning.dao.ICustomer;
import com.learning.model.Customer;

public class LearningSpring {
	public static void main(String[] args) {
		
		System.out.println("Learning spring..");
//		a in protoype scope
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		ICustomer customer=(ICustomer)context.getBean("customerDao");
		Customer customer_1=new Customer();
		customer_1.setId(10);
		customer_1.setName("Rishav");
		customer_1.setAge(22);
		customer.saveCustomer(customer_1);

		
//		classA a =(classA) context.getBean("a");
//		classA a1=(classA)context.getBean("a");
//		System.out.println(a);
//		System.out.println(a1);
//		a.methodA();
//		classCInterface c=(classCInterface) context.getBean("c");
//		c.methodC();
//		((AbstractApplicationContext)context).close();
//		
//		classB2 b=new classB2();
//		classA a=new classA(b);
//		classC c=new classC(b);
//		c.methodC();
	}

}
