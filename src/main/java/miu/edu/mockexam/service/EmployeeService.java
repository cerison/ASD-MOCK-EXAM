package miu.edu.mockexam.service;

import miu.edu.mockexam.dto.request.EmployeeRequest;
import miu.edu.mockexam.dto.response.EmployeeResponse;
import miu.edu.mockexam.dto.response.RetirementPlanResponse;
import miu.edu.mockexam.model.Employee;
import miu.edu.mockexam.model.RetirementPlan;
import miu.edu.mockexam.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    ModelMapper modelMapper;

    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll().stream().sorted(Comparator.comparing(Employee::getLastName)).toList();
    }
    public RetirementPlanResponse getRetirementPlan(Long id){
        var employee = employeeRepository.findById(id).orElse(null);

        if(employee != null){
            RetirementPlanResponse retirementPlanResponse = modelMapper.map(employee.getRetirementPlan(),RetirementPlanResponse.class);
            retirementPlanResponse.setEmployeeResponse(modelMapper.map(employee,EmployeeResponse.class));
            return retirementPlanResponse;
        }

        return null;
    }
    public RetirementPlanResponse addEmployee(EmployeeRequest employeeRequest){

        Employee employee = modelMapper.map(employeeRequest, Employee.class);
        employee.setRetirementPlan(modelMapper.map(employeeRequest, RetirementPlan.class));

        employeeRepository.save(employee);
        return getRetirementPlan(employee.getEmployeeId());
    }

    public List<Employee> upcomingRetirees() {
        LocalDate now = LocalDate.now();
        LocalDate startOfNextMonth = now.plusMonths(1).withDayOfMonth(1);
        LocalDate endOfNextMonth = startOfNextMonth.plusMonths(1).minusDays(1);

        return getAllEmployee().stream()
                .filter(employee -> {
                    LocalDate retirementDate = employee.getRetirementPlan().getRetirementDate();
                    return !retirementDate.isBefore(startOfNextMonth) && !retirementDate.isAfter(endOfNextMonth);
                })
                .sorted(Comparator.comparing(employee -> employee.getRetirementPlan().getRetirementDate()))
                .toList();
    }
}
