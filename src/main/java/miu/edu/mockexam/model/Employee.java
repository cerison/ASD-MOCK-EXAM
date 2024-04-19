package miu.edu.mockexam.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    @Column(nullable = false)
    @NotBlank
    private String firstName;
    @Column(nullable = false)
    @NotBlank
    private String lastName;
    @Column(nullable = true)
    private Float yearlySalary;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "planId", nullable = false)
    private RetirementPlan retirementPlan;
}
