package miu.edu.mockexam.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RetirementPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long planId;
    @Column(nullable = false, unique = true)
    @NotBlank
    private String referenceNumber;
    @Column(nullable = false)
    @NotBlank
    private LocalDate enrollmentDate;
    @Column(nullable = false)
    @NotBlank
    private LocalDate retirementDate;
    @Column(nullable = true)
    private Float monthlyContribution;
}
