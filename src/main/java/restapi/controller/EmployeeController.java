package restapi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	
	/*to save ane employee */
	@PostMapping("employees")
	public Employee createEmployee(@Valid @RequestBody Employee emp ) {
		return emploeeDAO.save(emp);
	}

}
