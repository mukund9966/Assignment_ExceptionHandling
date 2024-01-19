package com.ExceptionHandling.ExceptionHandling.service;

import com.ExceptionHandling.ExceptionHandling.Entity.Employee;

public interface EmployeeService {

    Employee createEmployee(String name, String email);
    void deleteEmpById(Long id);
    Employee updatePatient(Long id, String name, String email);

    Employee getEmpById(Long id);

}
