package com.exampleApiExampleHttpMethods.demo;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exampleApiExampleHttpMethods.demo.service.EmployeeService;



@RestController
public class EmployeeController {

	private static int count = 1;
	private HashMap<Integer, Employee> employeeMap = new HashMap<>();

	private static Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	
	
	EmployeeService empService;
	/*
	 * 
	 * { "name": "kishan",
	 * 
	 * "age": 0, "gender": "MALE" }
	 */

	/**
	 * HashMap - {emp id , emp details} Add a new employee - input : emp obj,
	 * output : boolean / emp obj Get details of particular employee - input :
	 * emp id , output : emp obj Get the list of all the employee : input : <>,
	 * output : List<emp> Update the details of an employee: input : id , output
	 * : boolean/ emp ob Delete an employee - input: id, output: boolean/emp
	 * obj/ list of emp after deletion
	 * 
	 */
	// http://localhost:8080/employee/add
	@PostMapping("/employee/add")
	public Employee addEmployee(@Valid @RequestBody Employee employee) {

		logger.info("this is info log from method: addEmployee");
		System.out.println("addEmployee : " +this);
		System.out.println("Inside employee addEmployee: 3333 ");
		// Employee employee2 = new Employee();
		employee.setId(count++);
		employee.setName(employee.getName());
		employee.setGender(employee.getGender());
		empService.manipulateDetails(employee);
		
		
		// employee2.setName(employee.getName());

		employeeMap.put(employee.getId(), employee);

		return employeeMap.get(employee.getId());
	}

	// http://localhost:8080/getEmployeeDetails?id=2
	@GetMapping("/getEmployeeDetails") // was intrduced in higher version
	public Employee getMyExamDetails(@RequestParam("id") int id) {
		System.out.println("getMyExamDetails: " + this);
		System.out.println("Value in the map" + employeeMap.get(id));
		System.out.println("Value in the map" + employeeMap.toString());
		return employeeMap.get(id);

	}

	// http://localhost:8080/employee/get/all
	@GetMapping("/employee/get/all") // was intrduced in higher version
	public List<Employee> getAllEmployees() {
		System.out.println("getAllEmployees: " + this);
		System.out.println("Value in the map" + employeeMap.toString());
		return employeeMap.values().stream().collect(Collectors.toList());

	}

	@PutMapping("/employee/update")
	public Employee updateDetails(@RequestBody Employee employee) throws Exception {
		employee.setAddress("added new address to 7781");
		if (employee.getId() == null) {
			throw new Exception("Id was not found");

		}

		if (!employeeMap.containsKey(employee.getId())) {

			throw new Exception("Employee is not found ");

		}
		employeeMap.put(employee.getId(), employee);

		return employee;

	}

	@DeleteMapping("/employee/delete/{id}")
	public Employee deleteEmployee(@PathVariable("id") int id) {

		return employeeMap.remove(id);

	}
	
	
	
	

}
