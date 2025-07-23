package io.lab.imHarish03.repository;

import io.lab.imHarish03.entity.Employee;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EmployeeRepository implements PanacheMongoRepository<Employee> {
	// You can add custom finder methods, for example:
	public Employee findByName(String name) {
		return find("name", name).firstResult();
	}

	public Employee findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
}
