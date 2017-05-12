package com.websystique.spring;

import java.math.BigDecimal;
import java.util.List;

import org.joda.time.LocalDate;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.StopWatch;

import com.websystique.spring.model.Employee;
import com.websystique.spring.service.EmployeeService;

public class HibCachingLevel1 {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext  context = new AnnotationConfigApplicationContext();
		context.scan("com.websystique.spring"); 
		context.refresh();
		EmployeeService service = (EmployeeService) context.getBean("employeeService");

		/*
		 * Create Employee1
		 */
	/*	for(int i = 1;i<100;i++){
			Employee employee1 = new Employee();
			employee1.setName("Tush "+i);
			employee1.setJoiningDate(new LocalDate(2016, 10, 10));
			employee1.setSalary(new BigDecimal(10000));
			employee1.setSsn("ssn0000000"+i);
			service.saveEmployee(employee1);
		}*/
		StopWatch stopWatch = new StopWatch("Determine Eligibility Stop Watch");
		stopWatch.start("initializing");
		System.out.println("Fetching First Time");
		List<Employee> employees = service.findAllEmployees();
		for (Employee emp : employees) {
			System.out.println(emp);
		}
		/*Employee employee2 = new Employee();
		employee2.setName("Kush");
		employee2.setJoiningDate(new LocalDate(2016, 11, 10));
		employee2.setSalary(new BigDecimal(20000));
		employee2.setSsn("ssn00076758");
		service.saveEmployee(employee2);
		*/
		
		System.out.println("Getting Again");
		List<Employee> employees2 = service.findAllEmployees();
		for (Employee emp : employees2) {
			System.out.println(emp);
		}

		stopWatch.stop();
		System.out.println(stopWatch.prettyPrint());
	}

}

//StopWatch 'Determine Eligibility Stop Watch': running time (millis) = 581 if cacheable
// StopWatch 'Determine Eligibility Stop Watch': running time (millis) = 664 if not cacheable
// absolutely no diff for 100 records
