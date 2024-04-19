package miu.edu.mockexam.controller;

import jakarta.persistence.GeneratedValue;
import miu.edu.mockexam.dto.request.EmployeeRequest;
import miu.edu.mockexam.dto.response.EmployeeResponse;
import miu.edu.mockexam.dto.response.RetirementPlanResponse;
import miu.edu.mockexam.model.Employee;
import miu.edu.mockexam.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mock/api/v1/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }

    @GetMapping("/{id}")
    public RetirementPlanResponse getRetirementPlan(@PathVariable Long id){
        return employeeService.getRetirementPlan(id);
    }

    @PostMapping
    public RetirementPlanResponse addEmployee(@RequestBody EmployeeRequest employeeRequest){
        return employeeService.addEmployee(employeeRequest);
    }

    @GetMapping("/show/upcomingretirees")
    public List<Employee> upcomingRetires(){
        return employeeService.upcomingRetirees();
    }

}
