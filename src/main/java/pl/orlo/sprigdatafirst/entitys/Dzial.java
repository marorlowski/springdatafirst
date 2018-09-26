package pl.orlo.sprigdatafirst.entitys;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class Dzial {


    @Id
    @GeneratedValue
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id_dzialu")
    public Set<Employee> employees;
    private Integer id_dzialu;
    private String nazwa_dzialu;
    private String lokalizacja;


    @OneToMany(mappedBy = "empDzial", cascade = CascadeType.ALL)
    public Set<Employee> getDzial() {
        return employees;
    }
  }
