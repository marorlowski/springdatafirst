package pl.orlo.sprigdatafirst;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.orlo.sprigdatafirst.entitys.Employee;
import pl.orlo.sprigdatafirst.repositorys.EmployeeRepostory;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Component
public class RunAtStart {
    private final EmployeeRepostory employeeRepostory;

    @Autowired
    public RunAtStart(EmployeeRepostory employeeRepostory) {
        this.employeeRepostory = employeeRepostory;
    }

    @PostConstruct
    public void runAtStart(){
//        Employee employee = new Employee();
//        employee.setFirstName("Kazimierz");
//        employee.setLastName("Brown");
//        employee.setSalary(new BigDecimal("4000.0"));
//        employee.getEmploymentDate(LocalDate.of(2016,1,1));
//
//        employeeRepostory.save(employee);

        List<Employee> jans = employeeRepostory.findByFirstName("Jan");
        Employee jan = jans.get(0);
        System.out.println("Janek: "+ jan);

        List<Employee> allEmployees= employeeRepostory.findAll();
        for(Employee i:allEmployees){
            System.out.println(i.getFirstName());
        }

    }
}
