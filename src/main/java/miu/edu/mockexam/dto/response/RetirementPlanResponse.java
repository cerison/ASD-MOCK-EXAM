package miu.edu.mockexam.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
public class RetirementPlanResponse {
    private Long planId;
    private String referenceNumber;
    private LocalDate enrollmentDate;
    private LocalDate retirementDate;
    private Float monthlyContribution;
    private EmployeeResponse employeeResponse;
}
