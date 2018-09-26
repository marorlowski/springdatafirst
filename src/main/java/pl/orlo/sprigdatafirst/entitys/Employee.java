package pl.orlo.sprigdatafirst.entitys;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
public class Employee {

    @Id
    @GeneratedValue
    private Integer id;

    private Dzial id_dzialu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_dzialu")
    public Dzial getEmployee(){
        return id_dzialu;
    };


    private String firstName;
    private String lastName;
    private BigDecimal salary;
    private LocalDate employmentDate;

}
