package com.spring.employee.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.employee.model.Employee;
import com.spring.employee.service.EmployeeService;
import com.spring.employee.util.EmailUtil;
import com.spring.employee.util.PDFGenerator;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@Autowired
	EmailUtil emailUtil;

	@Autowired
	PDFGenerator pdfGenerator;

	@Value("${com.employeeInfoSystem.itinerary.directoryPath}")
	private String ITINERARY_DIR;

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

	@RequestMapping("/addEmployee")
	public String addNewEmployee() {
		return "addEmployee";
	}

	@RequestMapping("/saveEmployeeToDB")
	@Transactional
	public String saveEmployeeToDB(@ModelAttribute("employee") Employee employee, ModelMap modelMap) {
		LOGGER.info("Inside saveEmployeeToDB(). Employee: " + employee);
		Employee savedEmployee = employeeService.saveEmployee(employee);
		String msg = "Employee is saved with Id: " + savedEmployee.getId();
		LOGGER.info("Inside saveEmployeeToDB(). Message is: " + msg);
		modelMap.addAttribute("message", msg);

		String filepath = ITINERARY_DIR + employee.getId() + ".pdf";
		LOGGER.info("Inside saveEmployeeToDB() and generating the itinerary");
		pdfGenerator.generateItinerary(employee, filepath);
		LOGGER.info("Inside saveEmployeeToDB() and emailing the itinerary");
		emailUtil.sendItinerary(employee.getEmail(), filepath);

		return "addEmployee";
	}

	@RequestMapping("/displayEmployee")
	public String displayEmployeeDetails(ModelMap modelMap) {
		List<Employee> employeeList = employeeService.getAllEmployees();
		LOGGER.info("Inside displayEmployeeDetails(). Employee List: " + employeeList);
		modelMap.addAttribute("listOfEmployee", employeeList);
		return "displayEmployee";
	}

	@RequestMapping("/deleteEmployee")
	public String deleteEmployee(@RequestParam("id") int empId, ModelMap modelMap) {
		LOGGER.info("Inside deleteEmployee(). Employee ID to be deleted: " + empId);
		Employee deleteEmployee = employeeService.getEmployeeById(empId);
		employeeService.deleteEmployee(deleteEmployee);
		List<Employee> updatedEmployeeList = employeeService.getAllEmployees();
		LOGGER.info("Inside deleteEmployee(). Updated Employee List: " + updatedEmployeeList);
		modelMap.addAttribute("listOfEmployee", updatedEmployeeList);
		return "displayEmployee";
	}

	@RequestMapping("/showEditEmployeePage")
	public String showEditEmployeeDetails(@RequestParam("id") int empId, ModelMap modelMap) {
		Employee updateEmployee = employeeService.getEmployeeById(empId);
		LOGGER.info("Inside showEditEmployeeDetails(). Employee ID to be updated: " + empId);
		modelMap.addAttribute("employeeUpdateDetails", updateEmployee);
		return "updateEmployee";
	}

	@RequestMapping("/updateEmployeeToDB")
	public String updateEmployeeDetails(@ModelAttribute("employee") Employee employee, ModelMap modelMap) {
		employeeService.updateEmployee(employee);
		List<Employee> modifiedEmployeeList = employeeService.getAllEmployees();
		LOGGER.info("Inside deleteEmployee(). Updated Employee List: " + modifiedEmployeeList);
		modelMap.addAttribute("listOfEmployee", modifiedEmployeeList);
		return "displayEmployee";
	}
}
