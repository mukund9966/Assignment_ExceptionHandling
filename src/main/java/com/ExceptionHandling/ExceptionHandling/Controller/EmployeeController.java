package com.ExceptionHandling.ExceptionHandling.Controller;

import com.ExceptionHandling.ExceptionHandling.Entity.Employee;
import com.ExceptionHandling.ExceptionHandling.dao.EmployeeDao;
import com.ExceptionHandling.ExceptionHandling.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping("/employee/create")
    public ResponseEntity<String> createEmployee(@RequestBody EmployeeDao employeeDao) {
        String name = employeeDao.getName();
        String email = employeeDao.getEmail();

        if (name == null || name.isEmpty()) {
            return ResponseEntity.badRequest().body("Name is required");
        }

        Employee createdEmployee = employeeService.createEmployee(name, email);

        return ResponseEntity.status(HttpStatus.CREATED).body("Employee created successfully");
    }



    @DeleteMapping("/employee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmpById(id);
        return ResponseEntity.ok("Employee deleted successfully");
    }

    @PutMapping("/employee/update/{id}")
    public ResponseEntity<Employee> updateEmployee(
            @PathVariable Long id,
            @RequestParam String name,
            @RequestParam String email
    ) {
        Employee updatedEmployee = employeeService.updatePatient(id, name, email);
        return ResponseEntity.ok(updatedEmployee);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeService.getEmpById(id);
        return ResponseEntity.ok(employee);
    }
}
