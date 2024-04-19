package miu.edu.mockexam.dto.request;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
public class EmployeeRequest {
    private String firstName;
    private String lastName;
    private Float yearlySalary;
    private String referenceNumber;
    private LocalDate enrollmentDate;
    private LocalDate retirementDate;
    private Float monthlyContribution;
}
