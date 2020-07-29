package restapi.dao;
import restapi.modal.Employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import restapi.repository.EmployeeRepository;


@Service
public class EmployeeDAO {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	
	/* to save and employee */
	public Employee save(Employee emp) {
		return employeeRepository.save(emp);
	}
	
	/*search all employee*/
	public List<Employee> findAll(){
		return employeeRepository.findAll();
	}
	 
	/*get an employee by id */
	public  Employee findOne(Long empid) {
		return employeeRepository.findOne(empid);
	}
	
	/*delete an employee */
	public void delete(Employee emp) {
		employeeRepository.delete(emp);
	}
	

}
