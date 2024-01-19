package com.ExceptionHandling.ExceptionHandling.dao;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.service.annotation.GetExchange;

@Getter
@Setter
public class EmployeeDao {
    private String name;
    private String email;
}
