package com.rec.spring;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ExampleServiceTest {

	private static final String HELLO_WORLD = "Hello world!";

	private ApplicationContext context;

	@Before
	public void setUp() {
		context = new ClassPathXmlApplicationContext("META-INF/spring/app-context.xml");
	}

	@After
	public void tearDown() {
		((AbstractApplicationContext) context).close();
	}

	@Test(expected = NoSuchBeanDefinitionException.class)
	public void getBean01() {
		context.getBean("exampleService", Service.class);
	}

	@Test
	public void getBean02() {
		Service bean = context.getBean("hello", Service.class);
		assertEquals(HELLO_WORLD, bean.getMessage());
	}

}
