package com.ar.hibernate;

import java.io.FileWriter;
import java.io.IOException;

import javax.xml.transform.stream.StreamResult;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.XmlMappingException;

public class EmployeeTest {

	public static void main(String[] args) throws XmlMappingException, IOException {
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		Marshaller m=(Marshaller) context.getBean("castorMarshallerBean");
		Employee e=new Employee();
		e.setId(101);
		e.setName("raheeman");
		e.setSalary(3099);
		m.marshal(e,new StreamResult(new FileWriter("empdoc.xml")));
		System.out.println("xml created successfully");
	}
}
