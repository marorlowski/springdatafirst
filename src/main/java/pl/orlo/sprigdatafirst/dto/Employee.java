package pl.orlo.sprigdatafirst.dto;

import lombok.Data;

import java.time.LocalDate;


@Data
public class Employee {
     private Integer id;
     private String firstName;
     private String lastName;
     private String salary;
     private LocalDate employmentDate;
}
