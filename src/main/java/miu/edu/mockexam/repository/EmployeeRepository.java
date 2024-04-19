package miu.edu.mockexam.repository;

import miu.edu.mockexam.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
