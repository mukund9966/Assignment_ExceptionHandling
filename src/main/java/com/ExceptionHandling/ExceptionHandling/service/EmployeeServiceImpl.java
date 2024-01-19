package com.ExceptionHandling.ExceptionHandling.service;

import com.ExceptionHandling.ExceptionHandling.Entity.Employee;
import com.ExceptionHandling.ExceptionHandling.Repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;
    @Override
    public Employee createEmployee(String name, String email) {
    if(name==null ||name.isEmpty()){
        throw new IllegalArgumentException("name is required");
    }
    Employee e1 = new Employee();
    e1.setName(name);
    e1.setEmail(email);
    return employeeRepository.save(e1);
    }

    @Override
    public void deleteEmpById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isEmpty()) throw new  RuntimeException("wrong id");
        Employee emp = employee.get();
        employeeRepository.delete(emp);

    }

    @Override
    public Employee updatePatient(Long id, String name, String email) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isEmpty()) throw new RuntimeException("Employee not found with id: " + id);

        Employee emp = employee.get();
        emp.setName(name);
        emp.setEmail(email);
        return employeeRepository.save(emp);
    }

    @Override
    public Employee getEmpById(Long id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if(employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            return employee;
        }
        else{
            throw  new IllegalArgumentException("Wrong id");
        }
    }
}
