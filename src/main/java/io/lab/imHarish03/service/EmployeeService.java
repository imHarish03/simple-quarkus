package io.lab.imHarish03.service;

import java.util.List;
import java.util.stream.Collectors;

import io.lab.imHarish03.dto.EmployeeDTO;
import io.lab.imHarish03.entity.Employee;
import io.lab.imHarish03.repository.EmployeeRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class EmployeeService {

	@Inject
	EmployeeRepository employeeRepository;

	public List<EmployeeDTO> getAllEmployees() {
		List<Employee> employees = employeeRepository.listAll();
		return employees.stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	public EmployeeDTO getEmployeeById(String id) {
		Employee employee = employeeRepository.findById(id);
		if (employee == null) {
			throw new RuntimeException("Employee not found");
		}
		return convertToDTO(employee);
	}

	public EmployeeDTO createEmployee(EmployeeDTO dto) {
		Employee employee = new Employee();
		employee.name = dto.name;
		employee.department = dto.department;
		employee.salary = dto.salary;
		employeeRepository.persist(employee);
		return convertToDTO(employee);
	}

	// Additional methods for update and delete...

	private EmployeeDTO convertToDTO(Employee employee) {
		EmployeeDTO dto = new EmployeeDTO();
		dto.id = employee.id.toString();
		dto.name = employee.name;
		dto.department = employee.department;
		dto.salary = employee.salary;
		return dto;
	}
}
