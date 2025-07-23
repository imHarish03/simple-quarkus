package io.lab.imHarish03.resource;

import java.util.List;

import io.lab.imHarish03.dto.EmployeeDTO;
import io.lab.imHarish03.service.EmployeeService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/employees")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmployeeResource {

	@Inject
	EmployeeService employeeService;

	@GET
	public List<EmployeeDTO> listEmployees() {
		return employeeService.getAllEmployees();
	}

	@GET
	@Path("/{id}")
	public EmployeeDTO getEmployee(@PathParam("id") String id) {
		return employeeService.getEmployeeById(id);
	}

	@POST
	public EmployeeDTO createEmployee(EmployeeDTO dto) {
		return employeeService.createEmployee(dto);
	}

	// Define endpoints for PUT (update) and DELETE as needed
}
