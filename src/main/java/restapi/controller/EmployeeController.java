package restapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import restapi.dao.EmployeeDAO;
import restapi.modal.Employee;

@RestController
@RequestMapping("/company")
public class EmployeeController {
	
	@Autowired
	EmployeeDAO emploeeDAO;
	
	
	/*to save an employee */
	@PostMapping("/employees")
	public Employee createEmployee(@Valid @RequestBody Employee emp ) {
		return emploeeDAO.save(emp);
	}
	
	/*get all employess */
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return emploeeDAO.findAll();
	}
	/*get Emeployee by id */
	@GetMapping("/notes/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value="id")Long empid){
		Employee emp=emploeeDAO.findOne(empid);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(emp);
		
	}
	
	/*Update and employee by empid*/ 
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value="id")Long empid,@Valid @RequestBody Employee empDetails){
		Employee emp=emploeeDAO.findOne(empid);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		emp.setName(empDetails.getName());
		emp.setDesignation(empDetails.getDesignation());
		emp.setExperstise(empDetails.getExperstise());
		Employee updateEmployee=emploeeDAO.save(emp);
		return ResponseEntity.ok().body(updateEmployee);
		
	}
	
	
	/*Delete an employee*/
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable(value="id")Long empid){
		Employee emp=emploeeDAO.findOne(empid);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		
		emploeeDAO.delete(emp);
		return ResponseEntity.ok().build();
	}
	

}
