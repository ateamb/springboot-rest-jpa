package com.javabanters.springboot.demo.service;

import com.javabanters.springboot.demo.dao.EmployeeRepository;
import com.javabanters.springboot.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  private EmployeeRepository employeeRepository;

  @Autowired
  public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  @Override
  public List<Employee> findAll() {
    return employeeRepository.findAll();
  }

  @Override
  public Employee findById(int id) {
    Optional<Employee> employee = employeeRepository.findById(id);
    Employee theEmployee = null;
    if(employee.isPresent()) theEmployee = employee.get();
    else throw new RuntimeException("COuldn't find employee with id" + id);
    return theEmployee;
  }

  @Override
  public Employee save(Employee employee) {
    return employeeRepository.save(employee);
  }

  @Override
  public void deleteById(int id) {
    employeeRepository.deleteById(id);
  }
}
